package Service;

import Model.Player;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Game {
    private Map<Integer, Player> playerMap;
    private TreeMap<Integer, Set<Integer>> rankToPlayerMap;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Game() {
        this.playerMap = new HashMap<>();
        this.rankToPlayerMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void addPlayer(Player player) throws Exception {
        if (Objects.isNull(player)) {
            throw new Exception("Player should be present");
        }
        lock.writeLock().lock();
        try {
            if (playerMap.containsKey(player.getId())) {
                throw new Exception("Player is already present");
            }
            playerMap.put(player.getId(), player);
            rankToPlayerMap.computeIfAbsent(player.getScore(), k -> new HashSet<>()).add(player.getId());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void addScore(Player player, int scoreToAdd) throws Exception {
        if (Objects.isNull(player)) {
            throw new Exception("Player should be present");
        }
        lock.writeLock().lock();
        try {
            if (!playerMap.containsKey(player.getId())) {
                throw new Exception("Player is Not registered present");
            }
            Set<Integer> oldBucket = rankToPlayerMap.get(player.getScore());
            oldBucket.remove(player.getId());
            if (oldBucket.isEmpty()) {
                rankToPlayerMap.remove(player.getScore());
            }
            int newScore = player.getScore() + scoreToAdd;
            player.setScore(newScore);
            rankToPlayerMap.computeIfAbsent(newScore, k -> new HashSet<>()).add(player.getId());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Player> getTopKScores(int k) {
        if (k <= 0) {
            return new ArrayList<>();
        }
        lock.readLock().lock();
        try {
            List<Player> players = new ArrayList<>();
            for (Set<Integer> bucket : rankToPlayerMap.values()) {
                for (int playerId : bucket) {
                    players.add(playerMap.get(playerId));
                    if (players.size() == k) return players;
                }
            }
            return players;
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getRank(int playerID) throws Exception {
        lock.readLock().lock();
        try {
            Player player = playerMap.get(playerID);
            if (Objects.isNull(player)) {
                throw new Exception("Player is not registered");
            }
            int score = player.getScore();
            int playersAbove = 0;
            for (Set<Integer> buckets : rankToPlayerMap.headMap(score, false).values()) {
                playersAbove += buckets.size();
            }
            return playersAbove + 1;
        } finally {
            lock.readLock().unlock();
        }
    }
}