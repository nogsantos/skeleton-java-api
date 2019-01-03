CREATE TABLE users (
  id      bigserial NOT NULL,
  name    varchar(99) NOT NULL,
  email   varchar(99) NOT NULL,
  password   varchar(99) NOT NULL,
  active   BOOLEAN DEFAULT TRUE,
  CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE roles (
  id      bigserial NOT NULL,
  name    varchar(99) NOT NULL,
  description   varchar(399) NOT NULL,
  active   BOOLEAN DEFAULT TRUE,
  CONSTRAINT roles_pk PRIMARY KEY (id)
);

CREATE TABLE user_role (
  user_id     bigserial NOT NULL,
  role_id    bigserial NOT NULL,
  CONSTRAINT user_role_pk PRIMARY KEY (user_id, role_id),
  CONSTRAINT user_role_fk foreign key (user_id) references users (id),
  CONSTRAINT role_user_fk foreign key (role_id) references roles (id)
);

-- Default User
insert into users (id, name, email, password, active) values
	(1, 'admin', 'nogsantos@gmail.com', '$2a$10$Pxm/QnTq86NyJ3JD5U.XcOrAe6cRIIv8.IPm6M9kp5o6twRD3Trgu', true),
	(2, 'guest', 'guest@mail.com', '$2a$10$Pxm/QnTq86NyJ3JD5U.XcOrAe6cRIIv8.IPm6M9kp5o6twRD3Trgu', true);

-- Default Roles
insert into roles (id, name, description, active) values
	(1, 'USER', 'User - has authority to view and list', true),
	(2, 'ADMIN', 'Admin - has authority to view and create and list', true),
	(3, 'SUPER_ADMIN', 'Super Admin - has authority to view, create and delete', true);

-- User Role
insert into user_role (user_id, role_id) values
	(1, 1),
	(1, 2),
	(1, 3),
	(2, 1);
