insert into roles(
        "id",
        "role_name"
    ) VALUES (
        1,
        'ROLE_SYSTEM_OWNER'
    );

insert into roles(
        "id",
        "role_name"
    ) VALUES (
        2,
        'ROLE_SYSTEM_ADMIN'
    );

insert into roles(
        "id",
        "role_name"
    ) VALUES (
        3,
        'ROLE_GUEST'
    );

insert into users_roles(
        "user_id",
        "role_id"
    ) VALUES (
        1,
        1
    );
