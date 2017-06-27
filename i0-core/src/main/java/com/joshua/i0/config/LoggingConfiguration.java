package com.joshua.i0.config;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.heren.i0.config.builder.Builder;
import com.heren.i0.config.builder.OptionalBuilder;
import com.heren.i0.config.util.LogLevel;
import com.heren.i0.config.util.Size;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Map;
import java.util.TimeZone;

import static com.google.common.base.Optional.absent;
import static com.google.common.base.Optional.of;

@XmlType
public class LoggingConfiguration {
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    @XmlType
    public static class ConsoleConfiguration {
        @NotNull
        private LogLevel level = LogLevel.ALL;

        @NotNull
        private Optional<String> format = Optional.absent();

        @NotNull
        private TimeZone timeZone = UTC;

        public ConsoleConfiguration() {
        }

        private ConsoleConfiguration(LogLevel level, Optional<String> format, TimeZone timeZone) {
            this.level = level;
            this.format = format;
            this.timeZone = timeZone;
        }

        @XmlElement
        public LogLevel getLevel() {
            return level;
        }

        @XmlElement
        public Optional<String> getFormat() {
            return format;
        }

        @XmlElement
        public TimeZone getTimeZone() {
            return timeZone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ConsoleConfiguration that = (ConsoleConfiguration) o;

            if (!format.equals(that.format)) return false;
            if (level != that.level) return false;
            if (!timeZone.equals(that.timeZone)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = level.hashCode();
            result = 31 * result + format.hashCode();
            result = 31 * result + timeZone.hashCode();
            return result;
        }
    }

    @XmlType
    public static class FileConfiguration {

        @XmlType
        public static class ArchiveConfiguration {
            @NotNull
            private String namePattern;

            private int maxHistory = 5;

            @NotNull
            private Size maxFileSize = new Size(100, Size.Unit.MB);

            public ArchiveConfiguration() {
            }

            private ArchiveConfiguration(String namePattern, int maxHistory, Size maxFileSize) {
                this.namePattern = namePattern;
                this.maxHistory = maxHistory;
                this.maxFileSize = maxFileSize;
            }

            @XmlElement
            public String getNamePattern() {
                return namePattern;
            }

            @XmlElement
            public int getMaxHistory() {
                return maxHistory;
            }

            @XmlElement
            public Size getMaxFileSize() {
                return maxFileSize;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                ArchiveConfiguration that = (ArchiveConfiguration) o;

                if (maxHistory != that.maxHistory) return false;
                if (!maxFileSize.equals(that.maxFileSize)) return false;
                if (!namePattern.equals(that.namePattern)) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = namePattern.hashCode();
                result = 31 * result + maxHistory;
                result = 31 * result + maxFileSize.hashCode();
                return result;
            }
        }

        @NotNull
        private LogLevel level = LogLevel.ALL;

        @NotNull
        private Optional<String> format = Optional.absent();

        @NotNull
        private TimeZone timeZone = UTC;

        @NotNull
        private String filename;


        @NotNull
        private Optional<ArchiveConfiguration> archive = Optional.absent();

        public FileConfiguration() {
        }

        private FileConfiguration(LogLevel level, Optional<String> format, TimeZone timeZone, String filename, Optional<ArchiveConfiguration> archive) {
            this.level = level;
            this.format = format;
            this.timeZone = timeZone;
            this.filename = filename;
            this.archive = archive;
        }

        @XmlElement
        public LogLevel getLevel() {
            return level;
        }

        @XmlElement
        public String getFilename() {
            return filename;
        }

        @XmlElement
        public Optional<String> getFormat() {
            return format;
        }

        @XmlElement
        public Optional<ArchiveConfiguration> getArchive() {
            return archive;
        }

        @XmlElement
        public TimeZone getTimeZone() {
            return timeZone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FileConfiguration that = (FileConfiguration) o;

            if (!archive.equals(that.archive)) return false;
            if (!filename.equals(that.filename)) return false;
            if (!format.equals(that.format)) return false;
            if (!level.equals(that.level)) return false;
            if (!timeZone.equals(that.timeZone)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = level.hashCode();
            result = 31 * result + filename.hashCode();
            result = 31 * result + format.hashCode();
            result = 31 * result + archive.hashCode();
            result = 31 * result + timeZone.hashCode();
            return result;
        }
    }

    @NotNull
    private LogLevel level = LogLevel.INFO;

    @NotNull
    private Map<String, LogLevel> loggers = ImmutableMap.of();

    @NotNull
    private Optional<ConsoleConfiguration> console = Optional.absent();

    @NotNull
    private Optional<FileConfiguration> file = Optional.absent();

    public LoggingConfiguration() {
    }

    private LoggingConfiguration(LogLevel level, Map<String, LogLevel> loggers, Optional<ConsoleConfiguration> console, Optional<FileConfiguration> file) {
        this.level = level;
        this.loggers = loggers;
        this.console = console;
        this.file = file;
    }

    @XmlElement
    public LogLevel getLevel() {
        return level;
    }

    @XmlElement
    public Map<String, LogLevel> getLoggers() {
        return loggers;
    }

    @XmlElement
    public Optional<ConsoleConfiguration> getConsole() {
        return console;
    }

    @XmlElement
    public Optional<FileConfiguration> getFile() {
        return file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoggingConfiguration that = (LoggingConfiguration) o;

        if (!console.equals(that.console)) return false;
        if (!file.equals(that.file)) return false;
        if (level != that.level) return false;
        if (!loggers.equals(that.loggers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = level.hashCode();
        result = 31 * result + loggers.hashCode();
        result = 31 * result + console.hashCode();
        result = 31 * result + file.hashCode();
        return result;
    }

    public static class LoggingConfigurationBuilder implements Builder<LoggingConfiguration> {
        private Configuration.ConfigurationBuilder parent;

        public class ConsoleConfigurationBuilder implements Builder<ConsoleConfiguration> {
            private LogLevel level = LogLevel.ALL;
            private Optional<String> format = absent();
            private TimeZone timeZone = TimeZone.getTimeZone("UTC");

            public ConsoleConfigurationBuilder() {
            }

            public ConsoleConfigurationBuilder level(LogLevel level) {
                this.level = level;
                return this;
            }

            public ConsoleConfigurationBuilder format(String format) {
                this.format = of(format);
                return this;
            }

            public ConsoleConfigurationBuilder timeZone(String timeZone) {
                this.timeZone = TimeZone.getTimeZone(timeZone);
                return this;
            }

            public ConsoleConfiguration build() {
                return new ConsoleConfiguration(level, format, timeZone);
            }

            public LoggingConfigurationBuilder end() {
                return LoggingConfigurationBuilder.this;
            }
        }

        public class FileConfigurationBuilder implements Builder<FileConfiguration> {
            private LogLevel level = LogLevel.ALL;
            private Optional<String> format = Optional.absent();
            private TimeZone timeZone = TimeZone.getTimeZone("UTC");
            private String filename;

            private OptionalBuilder<ArchiveConfigurationBuilder, FileConfiguration.ArchiveConfiguration>
                    archive = new OptionalBuilder<>(new ArchiveConfigurationBuilder());

            public FileConfigurationBuilder level(LogLevel level) {
                this.level = level;
                return this;
            }

            public FileConfigurationBuilder format(String format) {
                this.format = of(format);
                return this;
            }

            public FileConfigurationBuilder timeZone(String timeZone) {
                this.timeZone = TimeZone.getTimeZone(timeZone);
                return this;
            }

            public FileConfigurationBuilder filename(String filename) {
                this.filename = filename;
                return this;
            }

            public ArchiveConfigurationBuilder archive() {
                return this.archive.builder();
            }

            public FileConfiguration build() {
                return new FileConfiguration(level, format, timeZone, filename, archive.build());
            }

            public LoggingConfigurationBuilder end() {
                return LoggingConfigurationBuilder.this;
            }

            public class ArchiveConfigurationBuilder implements Builder<FileConfiguration.ArchiveConfiguration> {
                private String namePattern;
                private int maxHistory = 5;
                private Size maxFileSize = new Size(100, Size.Unit.MB);

                public ArchiveConfigurationBuilder namePattern(String namePattern) {
                    this.namePattern = namePattern;
                    return this;
                }

                public ArchiveConfigurationBuilder maxHistory(int maxHistory) {
                    this.maxHistory = maxHistory;
                    return this;
                }

                public ArchiveConfigurationBuilder maxFileSize(Size maxFileSize) {
                    this.maxFileSize = maxFileSize;
                    return this;
                }

                public FileConfiguration.ArchiveConfiguration build() {
                    return new FileConfiguration.ArchiveConfiguration(namePattern, maxHistory, maxFileSize);
                }

                public FileConfigurationBuilder end() {
                    return FileConfigurationBuilder.this;
                }
            }
        }

        private LogLevel level = LogLevel.INFO;
        private ImmutableMap.Builder<String, LogLevel> loggers = new ImmutableMap.Builder<>();

        private OptionalBuilder<ConsoleConfigurationBuilder, ConsoleConfiguration> console =
                new OptionalBuilder<>(new ConsoleConfigurationBuilder());
        private OptionalBuilder<FileConfigurationBuilder, FileConfiguration> file =
                new OptionalBuilder<>(new FileConfigurationBuilder());

        LoggingConfigurationBuilder(Configuration.ConfigurationBuilder parent) {
            this.parent = parent;
        }

        public LoggingConfigurationBuilder level(LogLevel level) {
            this.level = level;
            return this;
        }

        public LoggingConfigurationBuilder logger(String className, LogLevel level) {
            loggers.put(className, level);
            return this;
        }

        public LoggingConfigurationBuilder logger(Class<?> aClass, LogLevel level) {
            loggers.put(aClass.getName(), level);
            return this;
        }


        public ConsoleConfigurationBuilder console() {
            return console.builder();
        }

        public FileConfigurationBuilder file() {
            return file.builder();
        }

        public Configuration.ConfigurationBuilder end() {
            return parent;
        }

        public LoggingConfiguration build() {
            return new LoggingConfiguration(level, loggers.build(), console.build(), file.build());
        }
    }
}
