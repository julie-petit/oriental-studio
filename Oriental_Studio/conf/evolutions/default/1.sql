# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table actualite (
  id                        integer not null,
  date                      timestamp,
  description               varchar(255),
  active                    boolean,
  constraint pk_actualite primary key (id))
;

create table carte (
  nom                       varchar(255) not null,
  forfait_cours             float,
  reduction                 float,
  constraint pk_carte primary key (nom))
;

create table cours (
  plage_horaire             timestamp not null,
  duree_en_minutes          integer,
  discipline_nom            varchar(255),
  professeur_nom            varchar(255),
  constraint pk_cours primary key (plage_horaire))
;

create table discipline (
  nom                       varchar(255) not null,
  description               varchar(255),
  constraint pk_discipline primary key (nom))
;

create table inscrit_newsletter (
  email                     varchar(255) not null,
  constraint pk_inscrit_newsletter primary key (email))
;

create table professeur (
  nom                       varchar(255) not null,
  parcours_pro              varchar(255),
  url_avatar                varchar(255),
  constraint pk_professeur primary key (nom))
;

create sequence actualite_seq;

create sequence carte_seq;

create sequence cours_seq;

create sequence discipline_seq;

create sequence inscrit_newsletter_seq;

create sequence professeur_seq;

alter table cours add constraint fk_cours_discipline_1 foreign key (discipline_nom) references discipline (nom) on delete restrict on update restrict;
create index ix_cours_discipline_1 on cours (discipline_nom);
alter table cours add constraint fk_cours_professeur_2 foreign key (professeur_nom) references professeur (nom) on delete restrict on update restrict;
create index ix_cours_professeur_2 on cours (professeur_nom);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists actualite;

drop table if exists carte;

drop table if exists cours;

drop table if exists discipline;

drop table if exists inscrit_newsletter;

drop table if exists professeur;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists actualite_seq;

drop sequence if exists carte_seq;

drop sequence if exists cours_seq;

drop sequence if exists discipline_seq;

drop sequence if exists inscrit_newsletter_seq;

drop sequence if exists professeur_seq;

