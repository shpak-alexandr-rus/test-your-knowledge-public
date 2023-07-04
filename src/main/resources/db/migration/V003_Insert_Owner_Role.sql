-- Добавление в таблицу roles роли владельца системы (SYSTEM_OWNER)
insert into roles(
        "id",
        "role_name"
    ) VALUES (
        1,
        'ROLE_SYSTEM_OWNER'
    );

-- Добавление в таблицу roles роли администратора системы (SYSTEM_ADMIN)
insert into roles(
        "id",
        "role_name"
    ) VALUES (
        2,
        'ROLE_SYSTEM_ADMIN'
    );

-- Добавление в таблицу roles роли гостя (GUEST)
insert into roles(
        "id",
        "role_name"
    ) VALUES (
        3,
        'ROLE_GUEST'
    );

-- Добавление в таблицу users_roles записи, соответствующей присваиванию пользователю-владельцу системы
-- (на данный момент единственному зарегистрированному пользователю) роли SYSTEM_OWNER
insert into users_roles(
        "user_id",
        "role_id"
    ) VALUES (
        1,
        1
    );
