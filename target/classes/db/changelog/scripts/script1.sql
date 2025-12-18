CREATE SCHEMA utmn;

CREATE TABLE user_event (
    id          BIGSERIAL PRIMARY KEY,
    event_type  TEXT NOT NULL,
    event_time  TIMESTAMPTZ NOT NULL
);

CREATE INDEX idx_userevent_time ON user_event(event_time);
CREATE INDEX idx_userevent_type ON user_event(event_type);
