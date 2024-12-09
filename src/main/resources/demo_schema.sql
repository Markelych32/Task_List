CREATE SCHEMA IF NOT EXISTS tasklist;

CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

COMMENT ON TABLE users IS 'Таблица пользователей';

COMMENT ON COLUMN users.id IS 'Уникальный идентификатор пользователя';
COMMENT ON COLUMN users.name IS 'Имя пользователя в системе';
COMMENT ON COLUMN users.username IS 'Никнейм пользователя (электронная почта)';
COMMENT ON COLUMN users.password IS 'Пароль пользователя';

CREATE TABLE IF NOT EXISTS tasks
(
    id              BIGSERIAL PRIMARY KEY,
    user_id         BIGINT       NOT NULL,
    title           VARCHAR(255) NOT NULL,
    description     VARCHAR(255) DEFAULT NULL,
    status          VARCHAR(255) NOT NULL,
    expiration_date TIMESTAMP    NULL,

    CONSTRAINT FK_tasks_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);

COMMENT ON TABLE tasks IS 'Задачи пользователей';

COMMENT ON COLUMN tasks.id IS 'Уникальный идентификатор задачи';
COMMENT ON COLUMN tasks.user_id IS 'Идентификатор обладателя задачи';
COMMENT ON COLUMN tasks.title IS 'Заголовок задачи';
COMMENT ON COLUMN tasks.description IS 'Описание задачи';
COMMENT ON COLUMN tasks.status IS 'Статус задачи';
COMMENT ON COLUMN tasks.expiration_date IS 'Дедлайн задачи';

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id BIGINT       NOT NULL,
    role    VARCHAR(255) NOT NULL,

    CONSTRAINT PK_user_roles_user_id_role PRIMARY KEY (user_id, role),
    CONSTRAINT FK_user_roles_user_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION
);
