package core;

import java.time.Instant;

public class LogMessage {
    private final Instant timeStamp;
    private final LogLevel level;
    private final String message;

    @Override
    public String toString() {
        return "LogMessage{" +
                "timeStamp=" + timeStamp +
                ", level=" + level +
                ", message='" + message + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    private final String source;


    public Instant getTimeStamp() {
        return timeStamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getSource() {
        return source;
    }

    public LogMessage(Builder builder) {
        this.timeStamp = builder.timeStamp;
        this.message = builder.message;
        this.level = builder.level;
        this.source = builder.source;
    }


    public static class Builder {
        private Instant timeStamp = Instant.now();
        private LogLevel level;
        private String message;
        private String source;

        public Builder level(LogLevel level) {
            this.level = level;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder timestamp(Instant timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public LogMessage build() {
            if (level == null) {
                throw new IllegalArgumentException("Level is required");
            }
            if (message == null || message.trim().isEmpty()) {
                throw new IllegalArgumentException("Message should not be empty");
            }
            return new LogMessage(this);
        }
    }
}
