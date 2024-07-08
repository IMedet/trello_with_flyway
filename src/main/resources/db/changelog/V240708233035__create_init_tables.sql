CREATE TABLE permission(
                           id SERIAL PRIMARY KEY ,
                           permission varchar(255)
);

CREATE TABLE t_users(
                        id SERIAL PRIMARY KEY ,
                        email varchar(255),
                        full_name varchar(255),
                        password varchar(255)
);

CREATE Table task_categories(
                                id SERIAL PRIMARY KEY ,
                                name varchar(255)
);

CREATE TABLE folders(
                        id SERIAL PRIMARY KEY,
                        name varchar(255),
                        user_id bigint
);

Alter table folders
    Add constraint fki4m1exvjsp8kyjt90d50f5o6t
        FOREIGN KEY (user_id)
            references t_users (id)
            on update cascade ;

CREATE TABLE folders_categories(
                                   folders_id bigint,
                                   categories_id bigint
);

Alter table folders_categories
    Add constraint fk6gsmqbg8y88db7sqnkchaprcd
        FOREIGN KEY (folders_id)
            references folders (id)
            on update cascade ;

Alter table folders_categories
    Add constraint fkdk0dyl9hr54cjimure5nl5f8e
        FOREIGN KEY (categories_id)
            references task_categories (id)
            on update cascade ;

CREATE Table t_users_permissions(
                                    user_id SERIAL,
                                    permissions_id bigint
);

Alter table t_users_permissions
    Add constraint fk1aqgc2651y14fjqdvq9ytfwc1
        FOREIGN KEY (user_id)
            references t_users (id)
            on update cascade ;

Alter table t_users_permissions
    Add constraint fkhk3nel4iaho0fgo4swi39q8hu
        FOREIGN KEY (permissions_id)
            references permission (id)
            on update cascade ;

CREATE TABLE tasks(
                      id SERIAL PRIMARY KEY ,
                      description varchar(255),
                      status integer,
                      title varchar(255),
                      folder_id bigint
);

Alter table tasks
    Add constraint fk3rhp0o7hroaim305tw21wss8m
        FOREIGN KEY (folder_id)
            references folders (id)
            on update cascade ;


CREATE TABLE comments(
                         id SERIAL PRIMARY KEY,
                         comment varchar(255),
                         task_id SERIAL
);

Alter table comments
    Add constraint fki7pp0331nbiwd2844kg78kfwb
        FOREIGN KEY (task_id)
            references tasks (id)
            on update cascade ;