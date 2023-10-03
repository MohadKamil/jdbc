create table if not exists public.blog
(
    id          serial
    constraint blog_pk
    primary key,
    name        varchar(150) not null,
    blog_author integer
    );

alter table public.blog
    owner to root;

create table if not exists public.post
(
    id    serial
    constraint post_pk
    primary key,
    title varchar(250) not null,
    blog  integer      not null
    constraint post_blog_id_fk
    references public.blog
    );

alter table public.post
    owner to root;

create table if not exists public.author
(
    id   serial
    constraint author_pk
    primary key,
    name varchar(250) not null
    );

alter table public.author
    owner to root;

