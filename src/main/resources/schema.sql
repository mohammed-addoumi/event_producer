DROP TABLE IF EXISTS "event";
CREATE TABLE event (
    id   INTEGER      NOT NULL,
    name VARCHAR(128) NOT NULL,
    event_type VARCHAR(128) NOT NULL,
    status VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE event_duplicate (
    id   INTEGER      NOT NULL,
    name VARCHAR(128) NOT NULL,
    event_type VARCHAR(128) NOT NULL,
    status VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);