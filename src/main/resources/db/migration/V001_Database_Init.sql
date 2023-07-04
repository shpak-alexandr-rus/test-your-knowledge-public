-- Определяется порядок просмотра схем при поиске объектов
set search_path to tyk_schema;

-- Создание таблицы для хранения пользователей системы
create table if not exists users(
    "id" serial,                                   -- Колонка уникального идентификатора (главный ключ)
    "first_name" varchar(25) not null,             -- Колонка для хранения имени пользователя
    "middle_name" varchar(25) null,                -- Колонка для хранения отчества пользователя
    "last_name" varchar(40) not null,              -- Колонка для хранения фамилии пользователя
    "account_name" varchar(50) not null,           -- Колонка для хранения имени учетной записи пользователя
    "account_description" varchar(2000) default null,  -- Колонка для хранения описания учетной записи пользователя
    "password" varchar(1000) not null,             -- Колонка для хранения хеша пароля учетной записи
    "email" varchar(50) not null,                  -- Колонка для хранения электронной почты привязанной к учетной записи
    "phone_number" varchar(20) default null,       -- Колонка для хранения номера телефона привязанного к учетной записи
    "organization_id" uuid default null,           -- Колонка для хранения идентификатора организации, к которой привязан пользователь (задел на будущее)
    "account_locked" boolean default false,        -- Колонка для хранения признака блокировки учетной записи
    "account_enabled" boolean default false,       -- Колонка для хранения признака активности учетной записи
    "account_activated" boolean default false,     -- Колонка для хранения признака, что учетная запись была активирована
    "account_logo" varchar(8000) default null,     -- Колонка для хранения логотипа аккаунта - в BASE64 (возможно нужно использовать TEXT или BLOB). Или организовать какой-нибудь другой способ хранения логотипа
    "account_expiration_date" timestamp not null default now() + interval '1 year',             -- Колонка для хранения даты истечения активности учетной записи. (При каждом входе нужно отодвигать эту дату на год от текущей)
    "account_credentials_expiration_date" timestamp not null default now() - interval '1 day',  -- Колонка для хранения даты истечения актуальности пароля учетной записи.
    primary key("id"),                             -- Объявление главного ключа таблицы
    unique("account_name")                         -- Указывается, что значения "account_name" должны быть уникальны в таблице
);

-- Создание таблицы для хранения ролей пользователей системы
create table if not exists roles(
    "id" serial,                                   -- Колонка уникального идентификатора (главный ключ)
    "role_name" varchar(40) not null,              -- Колонка для хранения имени роли
    "role_description" varchar(2000) default null, -- Колонка для хранения описание роли
    "role_logo" varchar(8000) default null,        -- Колонка для хранения логотипа роли
    primary key("id")                              -- Объявление главного ключа таблицы
);

-- Создание таблицы для хранения связей пользователя и ролей (связь многие-ко-многим)
create table if not exists users_roles(
    "user_id" int,                                 -- Колонка уникального идентификатора таблицы пользователей (главный ключ)
    "role_id" int,                                 -- Колонка уникального идентификатора таблицы ролей (главный ключ)
    primary key("user_id", "role_id"),             -- Создается уникальный ключ для пары значений user_id и role_id
    foreign key ("user_id") references users("id"),-- Создание внешнего ключа на значение id таблицы пользователей
    foreign key ("role_id") references roles("id") -- Создание внешнего ключа на значение id таблицы ролей
);
