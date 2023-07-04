-- Добавление в таблицу users пользователя, который будет владельцем системы (SYSTEM_OWNER)
insert into users(
        "id",
        "first_name",
        "middle_name",
        "last_name",
        "account_name",
        "account_description",
        "password",
        "email",
        "phone_number",
        "organization_id"
    ) VALUES (
        1,
        'Alex',
        null,
        'Starling',
        'owner@gmail.com',
        null,
        '$2a$10$iAf43cbHA/CMgF7NnFIf0Ovh8.XMo0Xx.ktJgky2WXT9uKN/55Yxe', -- tyk_test_pass
        'owner@gmail.com',
        null,
        null
    );
