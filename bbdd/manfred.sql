-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-22 03:29:01.834

-- tables
-- Table: catalog
CREATE TABLE catalog (
                         catalog_id serial  NOT NULL,
                         description varchar(100)  NOT NULL,
                         version int  NOT NULL,
                         status varchar(25)  NOT NULL,
                         tx_user varchar(50)  NOT NULL,
                         tx_date timestamp  NOT NULL,
                         tx_host varchar(50)  NOT NULL,
                         CONSTRAINT catalog_pk PRIMARY KEY (catalog_id)
);

-- Table: company
CREATE TABLE company (
                         company_id serial  NOT NULL,
                         person_id int  NOT NULL,
                         company_name varchar(50)  NOT NULL,
                         logo_url varchar(100)  NOT NULL,
                         description varchar(500)  NOT NULL,
                         company_website varchar(100)  NOT NULL,
                         manager_name varchar(50)  NOT NULL,
                         manager_phone_number int  NOT NULL,
                         status varchar(25)  NOT NULL,
                         tx_user varchar(50)  NOT NULL,
                         tx_date timestamp  NOT NULL,
                         tx_host varchar(50)  NOT NULL,
                         CONSTRAINT company_pk PRIMARY KEY (company_id)
);

-- Table: company_requirement
CREATE TABLE company_requirement (
                                     company_requirement_id serial  NOT NULL,
                                     company_id int  NOT NULL,
                                     position_name varchar(50)  NOT NULL,
                                     description varchar(500)  NOT NULL,
                                     experience_time varchar(25)  NOT NULL,
                                     monthly_salary varchar(50)  NOT NULL,
                                     public_requirement int  NOT NULL,
                                     status varchar(25)  NOT NULL,
                                     tx_user varchar(50)  NOT NULL,
                                     tx_date timestamp  NOT NULL,
                                     tx_host varchar(50)  NOT NULL,
                                     work_modality varchar(50)  NOT NULL,
                                     CONSTRAINT company_requirement_pk PRIMARY KEY (company_requirement_id)
);

-- Table: company_requirement_language
CREATE TABLE company_requirement_language (
                                              company_requirement_language_id serial  NOT NULL,
                                              company_requirement_id int  NOT NULL,
                                              language_requirement varchar(25)  NOT NULL,
                                              status varchar(25)  NOT NULL,
                                              tx_user varchar(50)  NOT NULL,
                                              tx_date timestamp  NOT NULL,
                                              tx_host varchar(50)  NOT NULL,
                                              CONSTRAINT company_requirement_language_pk PRIMARY KEY (company_requirement_language_id)
);

-- Table: company_requirement_soft_skills
CREATE TABLE company_requirement_soft_skills (
                                                 company_requirement_soft_skills_id serial  NOT NULL,
                                                 company_requirement_id int  NOT NULL,
                                                 soft_skill_requirement varchar(50)  NOT NULL,
                                                 status varchar(25)  NOT NULL,
                                                 tx_user varchar(50)  NOT NULL,
                                                 tx_date timestamp  NOT NULL,
                                                 tx_host varchar(50)  NOT NULL,
                                                 CONSTRAINT company_requirement_soft_skills_pk PRIMARY KEY (company_requirement_soft_skills_id)
);

-- Table: company_requirement_techtools
CREATE TABLE company_requirement_techtools (
                                               company_requirement_techtools_id serial  NOT NULL,
                                               company_requirement_id int  NOT NULL,
                                               techtool_requirement varchar(50)  NOT NULL,
                                               status varchar(25)  NOT NULL,
                                               tx_user varchar(50)  NOT NULL,
                                               tx_date timestamp  NOT NULL,
                                               tx_host varchar(50)  NOT NULL,
                                               CONSTRAINT company_requirement_techtools_pk PRIMARY KEY (company_requirement_techtools_id)
);

-- Table: h_company
CREATE TABLE h_company (
                           h_company_id serial  NOT NULL,
                           company_id int  NOT NULL,
                           company_name varchar(50)  NOT NULL,
                           logo_url varchar(100)  NOT NULL,
                           description varchar(500)  NOT NULL,
                           company_website varchar(100)  NOT NULL,
                           manager_name varchar(50)  NOT NULL,
                           manager_phone_number int  NOT NULL,
                           status varchar(25)  NOT NULL,
                           tx_user varchar(50)  NOT NULL,
                           tx_date timestamp  NOT NULL,
                           tx_host varchar(50)  NOT NULL,
                           CONSTRAINT h_company_pk PRIMARY KEY (h_company_id)
);

-- Table: h_company_requirement
CREATE TABLE h_company_requirement (
                                       h_company_requirement_id serial  NOT NULL,
                                       company_requirement_id int  NOT NULL,
                                       company_id int  NOT NULL,
                                       position_name varchar(50)  NOT NULL,
                                       description varchar(500)  NOT NULL,
                                       experience_time varchar(25)  NOT NULL,
                                       monthly_salary varchar(50)  NOT NULL,
                                       public_requirement int  NOT NULL,
                                       status varchar(25)  NOT NULL,
                                       tx_user varchar(50)  NOT NULL,
                                       tx_date timestamp  NOT NULL,
                                       tx_host varchar(50)  NOT NULL,
                                       CONSTRAINT h_company_requirement_pk PRIMARY KEY (h_company_requirement_id)
);

-- Table: h_preselection_interview
CREATE TABLE h_preselection_interview (
                                          h_preselection_interview_id serial  NOT NULL,
                                          preselection_interview_id int  NOT NULL,
                                          company_requirement_id int  NOT NULL,
                                          user_id int  NOT NULL,
                                          date date  NOT NULL,
                                          time time  NOT NULL,
                                          address varchar(100)  NOT NULL,
                                          status varchar(25)  NOT NULL,
                                          tx_user varchar(50)  NOT NULL,
                                          tx_date timestamp  NOT NULL,
                                          tx_host varchar(50)  NOT NULL,
                                          CONSTRAINT h_preselection_interview_pk PRIMARY KEY (h_preselection_interview_id)
);

-- Table: h_user
CREATE TABLE h_user (
                        h_user_id serial  NOT NULL,
                        user_id int  NOT NULL,
                        first_name varchar(25)  NOT NULL,
                        middle_name varchar(25)  NOT NULL,
                        last_name varchar(25)  NOT NULL,
                        second_name varchar(25)  NOT NULL,
                        country varchar(50)  NOT NULL,
                        city varchar(50)  NOT NULL,
                        presentation varchar(500)  NOT NULL,
                        experience varchar(25)  NOT NULL,
                        ideal_job varchar(500)  NOT NULL,
                        wanted_salary varchar(25)  NOT NULL,
                        work_modality varchar(50)  NOT NULL,
                        linkedin_url varchar(100)  NOT NULL,
                        cv varchar(100)  NOT NULL,
                        twitter_url varchar(100)  NOT NULL,
                        github_url varchar(100)  NOT NULL,
                        stackoverflow_url varchar(100)  NOT NULL,
                        website_url varchar(100)  NOT NULL,
                        phone_number int  NOT NULL,
                        status varchar(25)  NOT NULL,
                        tx_user varchar(50)  NOT NULL,
                        tx_date timestamp  NOT NULL,
                        tx_host varchar(50)  NOT NULL,
                        CONSTRAINT h_user_pk PRIMARY KEY (h_user_id)
);

-- Table: h_user_application
CREATE TABLE h_user_application (
                                    h_user_application_id serial  NOT NULL,
                                    user_application_id int  NOT NULL,
                                    company_requirement_id int  NOT NULL,
                                    user_id int  NOT NULL,
                                    status_application varchar(25)  NOT NULL,
                                    date date  NOT NULL,
                                    time time  NOT NULL,
                                    status varchar(25)  NOT NULL,
                                    tx_user varchar(50)  NOT NULL,
                                    tx_date timestamp  NOT NULL,
                                    tx_host varchar(50)  NOT NULL,
                                    CONSTRAINT h_user_application_pk PRIMARY KEY (h_user_application_id)
);

-- Table: h_user_application_interview
CREATE TABLE h_user_application_interview (
                                              h_user_application_id serial  NOT NULL,
                                              user_application_interview_id int  NOT NULL,
                                              user_application_id int  NOT NULL,
                                              date date  NOT NULL,
                                              time time  NOT NULL,
                                              address varchar(100)  NOT NULL,
                                              status varchar(25)  NOT NULL,
                                              tx_user varchar(50)  NOT NULL,
                                              tx_date timestamp  NOT NULL,
                                              tx_host varchar(50)  NOT NULL,
                                              CONSTRAINT h_user_application_interview_pk PRIMARY KEY (h_user_application_id)
);

-- Table: hierarchy
CREATE TABLE hierarchy (
                           hierarchy_id serial  NOT NULL,
                           father_id int  NOT NULL,
                           children_id int  NOT NULL,
                           tx_user varchar(50)  NOT NULL,
                           tx_date timestamp  NOT NULL,
                           tx_host varchar(50)  NOT NULL,
                           CONSTRAINT hierarchy_pk PRIMARY KEY (hierarchy_id)
);

-- Table: language_user
CREATE TABLE language_user (
                               language_user_id serial  NOT NULL,
                               user_id int  NOT NULL,
                               language varchar(25)  NOT NULL,
                               status varchar(25)  NOT NULL,
                               tx_user varchar(50)  NOT NULL,
                               tx_date timestamp  NOT NULL,
                               tx_host varchar(50)  NOT NULL,
                               CONSTRAINT language_user_pk PRIMARY KEY (language_user_id)
);

-- Table: manfred_group
CREATE TABLE manfred_group (
                               group_id serial  NOT NULL,
                               name varchar(50)  NOT NULL,
                               description varchar(200)  NOT NULL,
                               status varchar(25)  NOT NULL,
                               tx_user varchar(50)  NOT NULL,
                               tx_date timestamp  NOT NULL,
                               tx_host varchar(50)  NOT NULL,
                               CONSTRAINT manfred_group_pk PRIMARY KEY (group_id)
);

-- Table: manfred_group_role
CREATE TABLE manfred_group_role (
                                    group_role_id serial  NOT NULL,
                                    role_id int  NOT NULL,
                                    group_id int  NOT NULL,
                                    status varchar(25)  NOT NULL,
                                    tx_user varchar(50)  NOT NULL,
                                    tx_date timestamp  NOT NULL,
                                    tx_host varchar(50)  NOT NULL,
                                    CONSTRAINT manfred_group_role_pk PRIMARY KEY (group_role_id)
);

-- Table: manfred_person_group
CREATE TABLE manfred_person_group (
                                      person_group_id serial  NOT NULL,
                                      person_id int  NOT NULL,
                                      group_id int  NOT NULL,
                                      status varchar(25)  NOT NULL,
                                      tx_user varchar(50)  NOT NULL,
                                      tx_date timestamp  NOT NULL,
                                      tx_host varchar(50)  NOT NULL,
                                      CONSTRAINT manfred_person_group_pk PRIMARY KEY (person_group_id)
);

-- Table: manfred_role
CREATE TABLE manfred_role (
                              role_id serial  NOT NULL,
                              name varchar(50)  NOT NULL,
                              description varchar(200)  NOT NULL,
                              status varchar(25)  NOT NULL,
                              tx_user varchar(50)  NOT NULL,
                              tx_date timestamp  NOT NULL,
                              tx_host varchar(50)  NOT NULL,
                              CONSTRAINT manfred_role_pk PRIMARY KEY (role_id)
);

-- Table: option
CREATE TABLE option (
                        option_id serial  NOT NULL,
                        catalog_id int  NOT NULL,
                        label varchar(100)  NOT NULL,
                        version int  NOT NULL,
                        status varchar(25)  NOT NULL,
                        tx_user varchar(50)  NOT NULL,
                        tx_date timestamp  NOT NULL,
                        tx_host varchar(50)  NOT NULL,
                        CONSTRAINT option_pk PRIMARY KEY (option_id)
);

-- Table: person
CREATE TABLE person (
                        person_id serial  NOT NULL,
                        email varchar(50)  NOT NULL,
                        password varchar(50)  NOT NULL,
                        status varchar(25)  NOT NULL,
                        tx_user varchar(50)  NOT NULL,
                        tx_date timestamp  NOT NULL,
                        tx_host varchar(50)  NOT NULL,
                        CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: preselection_interview
CREATE TABLE preselection_interview (
                                        preselection_interview_id serial  NOT NULL,
                                        company_requirement_id int  NOT NULL,
                                        date date  NOT NULL,
                                        time time  NOT NULL,
                                        address varchar(100)  NOT NULL,
                                        status varchar(25)  NOT NULL,
                                        tx_user varchar(50)  NOT NULL,
                                        tx_date timestamp  NOT NULL,
                                        tx_host varchar(50)  NOT NULL,
                                        CONSTRAINT preselection_interview_pk PRIMARY KEY (preselection_interview_id)
);

-- Table: soft_skills_user
CREATE TABLE soft_skills_user (
                                  soft_skills_user_id serial  NOT NULL,
                                  user_id int  NOT NULL,
                                  soft_skill varchar(50)  NOT NULL,
                                  status varchar(25)  NOT NULL,
                                  tx_user varchar(50)  NOT NULL,
                                  tx_date timestamp  NOT NULL,
                                  tx_host varchar(50)  NOT NULL,
                                  CONSTRAINT soft_skills_user_pk PRIMARY KEY (soft_skills_user_id)
);

-- Table: techtools_certification_user
CREATE TABLE techtools_certification_user (
                                              techtools_certification_user_id serial  NOT NULL,
                                              user_certification_id int  NOT NULL,
                                              techtool_certification varchar(50)  NOT NULL,
                                              status varchar(25)  NOT NULL,
                                              tx_user varchar(50)  NOT NULL,
                                              tx_date timestamp  NOT NULL,
                                              tx_host varchar(50)  NOT NULL,
                                              CONSTRAINT techtools_certification_user_pk PRIMARY KEY (techtools_certification_user_id)
);

-- Table: techtools_education_user
CREATE TABLE techtools_education_user (
                                          techtools_education_user_id serial  NOT NULL,
                                          user_education_id int  NOT NULL,
                                          techtool_education varchar(50)  NOT NULL,
                                          status varchar(25)  NOT NULL,
                                          tx_user varchar(50)  NOT NULL,
                                          tx_date timestamp  NOT NULL,
                                          tx_host varchar(50)  NOT NULL,
                                          CONSTRAINT techtools_education_user_pk PRIMARY KEY (techtools_education_user_id)
);

-- Table: techtools_user
CREATE TABLE techtools_user (
                                techtools_user_id serial  NOT NULL,
                                user_id int  NOT NULL,
                                techtool varchar(50)  NOT NULL,
                                status varchar(25)  NOT NULL,
                                tx_user varchar(50)  NOT NULL,
                                tx_date timestamp  NOT NULL,
                                tx_host varchar(50)  NOT NULL,
                                CONSTRAINT techtools_user_pk PRIMARY KEY (techtools_user_id)
);

-- Table: unwanted_techtools_user
CREATE TABLE unwanted_techtools_user (
                                         unwanted_techtool_user_id serial  NOT NULL,
                                         user_id int  NOT NULL,
                                         unwanted_techtool varchar(50)  NOT NULL,
                                         status varchar(25)  NOT NULL,
                                         tx_user varchar(50)  NOT NULL,
                                         tx_date timestamp  NOT NULL,
                                         tx_host varchar(50)  NOT NULL,
                                         CONSTRAINT unwanted_techtools_user_pk PRIMARY KEY (unwanted_techtool_user_id)
);

-- Table: used_techtools_project_user
CREATE TABLE used_techtools_project_user (
                                             used_techtools_project_user_id serial  NOT NULL,
                                             user_project_id int  NOT NULL,
                                             techtool_project varchar(50)  NOT NULL,
                                             status varchar(25)  NOT NULL,
                                             tx_user varchar(50)  NOT NULL,
                                             tx_date timestamp  NOT NULL,
                                             tx_host varchar(50)  NOT NULL,
                                             CONSTRAINT used_techtools_project_user_pk PRIMARY KEY (used_techtools_project_user_id)
);

-- Table: used_techtools_user_job
CREATE TABLE used_techtools_user_job (
                                         used_techtools_user_job_id serial  NOT NULL,
                                         user_workexperience_id int  NOT NULL,
                                         used_techtool varchar(50)  NOT NULL,
                                         status varchar(25)  NOT NULL,
                                         tx_user varchar(50)  NOT NULL,
                                         tx_date timestamp  NOT NULL,
                                         tx_host varchar(50)  NOT NULL,
                                         CONSTRAINT used_techtools_user_job_pk PRIMARY KEY (used_techtools_user_job_id)
);

-- Table: user
CREATE TABLE "user" (
                        user_id serial  NOT NULL,
                        person_id int  NOT NULL,
                        first_name varchar(25)  NOT NULL,
                        surname varchar(25)  NOT NULL,
                        country varchar(50)  NOT NULL,
                        city varchar(50)  NOT NULL,
                        presentation varchar(500)  NOT NULL,
                        experience varchar(25)  NOT NULL,
                        ideal_job varchar(500)  NOT NULL,
                        wanted_salary varchar(25)  NOT NULL,
                        work_modality varchar(50)  NOT NULL,
                        linkedin_url varchar(100)  NOT NULL,
                        cv varchar(100)  NOT NULL,
                        twitter_url varchar(100)  NOT NULL,
                        github_url varchar(100)  NOT NULL,
                        stackoverflow_url varchar(100)  NOT NULL,
                        website_url varchar(100)  NOT NULL,
                        phone_number varchar(25)  NOT NULL,
                        status varchar(25)  NOT NULL,
                        tx_user varchar(50)  NOT NULL,
                        tx_date timestamp  NOT NULL,
                        tx_host varchar(50)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: user_application
CREATE TABLE user_application (
                                  user_application_id serial  NOT NULL,
                                  company_requirement_id int  NOT NULL,
                                  user_id int  NOT NULL,
                                  status_application varchar(25)  NOT NULL,
                                  date date  NOT NULL,
                                  time time  NOT NULL,
                                  status varchar(25)  NOT NULL,
                                  tx_user varchar(50)  NOT NULL,
                                  tx_date timestamp  NOT NULL,
                                  tx_host varchar(50)  NOT NULL,
                                  CONSTRAINT user_application_pk PRIMARY KEY (user_application_id)
);

-- Table: user_application_interview
CREATE TABLE user_application_interview (
                                            user_application_interview_id serial  NOT NULL,
                                            user_application_id int  NOT NULL,
                                            date date  NOT NULL,
                                            time time  NOT NULL,
                                            address varchar(100)  NOT NULL,
                                            status varchar(25)  NOT NULL,
                                            tx_user varchar(50)  NOT NULL,
                                            tx_date timestamp  NOT NULL,
                                            tx_host varchar(50)  NOT NULL,
                                            CONSTRAINT user_application_interview_pk PRIMARY KEY (user_application_interview_id)
);

-- Table: user_certification
CREATE TABLE user_certification (
                                    user_certification_id serial  NOT NULL,
                                    user_id int  NOT NULL,
                                    certification_name varchar(50)  NOT NULL,
                                    description varchar(500)  NOT NULL,
                                    certification_date date  NOT NULL,
                                    end_certification_date date  NOT NULL,
                                    issuing_organization varchar(100)  NOT NULL,
                                    certification_url varchar(100)  NOT NULL,
                                    status varchar(25)  NOT NULL,
                                    tx_user varchar(50)  NOT NULL,
                                    tx_date timestamp  NOT NULL,
                                    tx_host varchar(50)  NOT NULL,
                                    CONSTRAINT user_certification_pk PRIMARY KEY (user_certification_id)
);

-- Table: user_education
CREATE TABLE user_education (
                                user_education_id serial  NOT NULL,
                                user_id int  NOT NULL,
                                type varchar(25)  NOT NULL,
                                education_title varchar(50)  NOT NULL,
                                description varchar(500)  NOT NULL,
                                start_education_date date  NOT NULL,
                                end_education_date date  NULL,
                                institution_name varchar(100)  NOT NULL,
                                status varchar(25)  NOT NULL,
                                tx_user varchar(50)  NOT NULL,
                                tx_date timestamp  NOT NULL,
                                tx_host varchar(50)  NOT NULL,
                                CONSTRAINT user_education_pk PRIMARY KEY (user_education_id)
);

-- Table: user_project
CREATE TABLE user_project (
                              user_project_id serial  NOT NULL,
                              user_id int  NOT NULL,
                              type varchar(25)  NOT NULL,
                              project_name varchar(50)  NOT NULL,
                              description varchar(500)  NOT NULL,
                              start_project_date date  NOT NULL,
                              end_project_date date  NULL,
                              status varchar(25)  NOT NULL,
                              tx_user varchar(50)  NOT NULL,
                              tx_date timestamp  NOT NULL,
                              tx_host varchar(50)  NOT NULL,
                              CONSTRAINT user_project_pk PRIMARY KEY (user_project_id)
);

-- Table: user_workexperience
CREATE TABLE user_workexperience (
                                     user_workexperience_id serial  NOT NULL,
                                     user_id int  NOT NULL,
                                     position varchar(50)  NOT NULL,
                                     description varchar(500)  NOT NULL,
                                     start_date date  NOT NULL,
                                     end_date date  NOT NULL,
                                     company_name varchar(50)  NOT NULL,
                                     company_url varchar(100)  NOT NULL,
                                     status varchar(25)  NOT NULL,
                                     tx_user varchar(50)  NOT NULL,
                                     tx_date timestamp  NOT NULL,
                                     tx_host varchar(50)  NOT NULL,
                                     CONSTRAINT user_workexperience_pk PRIMARY KEY (user_workexperience_id)
);

-- Table: wanted_position_user
CREATE TABLE wanted_position_user (
                                      wanted_position_user_id serial  NOT NULL,
                                      user_id int  NOT NULL,
                                      position varchar(50)  NOT NULL,
                                      status varchar(25)  NOT NULL,
                                      tx_user varchar(50)  NOT NULL,
                                      tx_date timestamp  NOT NULL,
                                      tx_host varchar(50)  NOT NULL,
                                      CONSTRAINT wanted_position_user_pk PRIMARY KEY (wanted_position_user_id)
);

-- Table: wanted_techtools_user
CREATE TABLE wanted_techtools_user (
                                       wanted_techtool_user_id serial  NOT NULL,
                                       user_id int  NOT NULL,
                                       wanted_techtool varchar(50)  NOT NULL,
                                       status varchar(25)  NOT NULL,
                                       tx_user varchar(50)  NOT NULL,
                                       tx_date timestamp  NOT NULL,
                                       tx_host varchar(50)  NOT NULL,
                                       CONSTRAINT wanted_techtools_user_pk PRIMARY KEY (wanted_techtool_user_id)
);

-- foreign keys
-- Reference: Copy_of_preselection_interview_preselection_interview (table: h_preselection_interview)
ALTER TABLE h_preselection_interview ADD CONSTRAINT Copy_of_preselection_interview_preselection_interview
    FOREIGN KEY (preselection_interview_id)
        REFERENCES preselection_interview (preselection_interview_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_person (table: company)
ALTER TABLE company ADD CONSTRAINT company_person
    FOREIGN KEY (person_id)
        REFERENCES person (person_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_requirement_company (table: company_requirement)
ALTER TABLE company_requirement ADD CONSTRAINT company_requirement_company
    FOREIGN KEY (company_id)
        REFERENCES company (company_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_requirement_language_company_requirement (table: company_requirement_language)
ALTER TABLE company_requirement_language ADD CONSTRAINT company_requirement_language_company_requirement
    FOREIGN KEY (company_requirement_id)
        REFERENCES company_requirement (company_requirement_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_requirement_soft_skills_company_requirement (table: company_requirement_soft_skills)
ALTER TABLE company_requirement_soft_skills ADD CONSTRAINT company_requirement_soft_skills_company_requirement
    FOREIGN KEY (company_requirement_id)
        REFERENCES company_requirement (company_requirement_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: company_requirement_techtools_company_requirement (table: company_requirement_techtools)
ALTER TABLE company_requirement_techtools ADD CONSTRAINT company_requirement_techtools_company_requirement
    FOREIGN KEY (company_requirement_id)
        REFERENCES company_requirement (company_requirement_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: h_application_interview_user_application_interview (table: h_user_application_interview)
ALTER TABLE h_user_application_interview ADD CONSTRAINT h_application_interview_user_application_interview
    FOREIGN KEY (user_application_interview_id)
        REFERENCES user_application_interview (user_application_interview_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: h_company_company (table: h_company)
ALTER TABLE h_company ADD CONSTRAINT h_company_company
    FOREIGN KEY (company_id)
        REFERENCES company (company_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: h_company_requirement_company_requirement (table: h_company_requirement)
ALTER TABLE h_company_requirement ADD CONSTRAINT h_company_requirement_company_requirement
    FOREIGN KEY (company_requirement_id)
        REFERENCES company_requirement (company_requirement_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: h_user_about_me_user (table: h_user)
ALTER TABLE h_user ADD CONSTRAINT h_user_about_me_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: h_user_application_user_application (table: h_user_application)
ALTER TABLE h_user_application ADD CONSTRAINT h_user_application_user_application
    FOREIGN KEY (user_application_id)
        REFERENCES user_application (user_application_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: hierarchy_option1 (table: hierarchy)
ALTER TABLE hierarchy ADD CONSTRAINT hierarchy_option1
    FOREIGN KEY (father_id)
        REFERENCES option (option_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: hierarchy_option2 (table: hierarchy)
ALTER TABLE hierarchy ADD CONSTRAINT hierarchy_option2
    FOREIGN KEY (children_id)
        REFERENCES option (option_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: language_user_user_about_me (table: language_user)
ALTER TABLE language_user ADD CONSTRAINT language_user_user_about_me
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: manfred_group_role_manfred_group (table: manfred_group_role)
ALTER TABLE manfred_group_role ADD CONSTRAINT manfred_group_role_manfred_group
    FOREIGN KEY (group_id)
        REFERENCES manfred_group (group_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: manfred_group_role_manfred_role (table: manfred_group_role)
ALTER TABLE manfred_group_role ADD CONSTRAINT manfred_group_role_manfred_role
    FOREIGN KEY (role_id)
        REFERENCES manfred_role (role_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: manfred_person_group_manfred_group (table: manfred_person_group)
ALTER TABLE manfred_person_group ADD CONSTRAINT manfred_person_group_manfred_group
    FOREIGN KEY (group_id)
        REFERENCES manfred_group (group_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: manfred_person_group_person (table: manfred_person_group)
ALTER TABLE manfred_person_group ADD CONSTRAINT manfred_person_group_person
    FOREIGN KEY (person_id)
        REFERENCES person (person_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: option_catalog (table: option)
ALTER TABLE option ADD CONSTRAINT option_catalog
    FOREIGN KEY (catalog_id)
        REFERENCES catalog (catalog_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: preselection_interview_company_requirement (table: preselection_interview)
ALTER TABLE preselection_interview ADD CONSTRAINT preselection_interview_company_requirement
    FOREIGN KEY (company_requirement_id)
        REFERENCES company_requirement (company_requirement_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: soft_skills_user_user_about_me (table: soft_skills_user)
ALTER TABLE soft_skills_user ADD CONSTRAINT soft_skills_user_user_about_me
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: techtools_certification_user_user_certification (table: techtools_certification_user)
ALTER TABLE techtools_certification_user ADD CONSTRAINT techtools_certification_user_user_certification
    FOREIGN KEY (user_certification_id)
        REFERENCES user_certification (user_certification_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: techtools_education_user_user_education (table: techtools_education_user)
ALTER TABLE techtools_education_user ADD CONSTRAINT techtools_education_user_user_education
    FOREIGN KEY (user_education_id)
        REFERENCES user_education (user_education_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: techtools_user_user_about_me (table: techtools_user)
ALTER TABLE techtools_user ADD CONSTRAINT techtools_user_user_about_me
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: unwanted_techtools_user_user_about_me (table: unwanted_techtools_user)
ALTER TABLE unwanted_techtools_user ADD CONSTRAINT unwanted_techtools_user_user_about_me
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: used_techtools_project_user_user_project (table: used_techtools_project_user)
ALTER TABLE used_techtools_project_user ADD CONSTRAINT used_techtools_project_user_user_project
    FOREIGN KEY (user_project_id)
        REFERENCES user_project (user_project_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: used_techtools_user_job_user_workexperience (table: used_techtools_user_job)
ALTER TABLE used_techtools_user_job ADD CONSTRAINT used_techtools_user_job_user_workexperience
    FOREIGN KEY (user_workexperience_id)
        REFERENCES user_workexperience (user_workexperience_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_application_company_requirement (table: user_application)
ALTER TABLE user_application ADD CONSTRAINT user_application_company_requirement
    FOREIGN KEY (company_requirement_id)
        REFERENCES company_requirement (company_requirement_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_application_interview_user_application (table: user_application_interview)
ALTER TABLE user_application_interview ADD CONSTRAINT user_application_interview_user_application
    FOREIGN KEY (user_application_id)
        REFERENCES user_application (user_application_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_application_user (table: user_application)
ALTER TABLE user_application ADD CONSTRAINT user_application_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_certification_user (table: user_certification)
ALTER TABLE user_certification ADD CONSTRAINT user_certification_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_education_user (table: user_education)
ALTER TABLE user_education ADD CONSTRAINT user_education_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_person (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_person
    FOREIGN KEY (person_id)
        REFERENCES person (person_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_project_user (table: user_project)
ALTER TABLE user_project ADD CONSTRAINT user_project_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_workexperience_user (table: user_workexperience)
ALTER TABLE user_workexperience ADD CONSTRAINT user_workexperience_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: wanted_position_user_user_about_me (table: wanted_position_user)
ALTER TABLE wanted_position_user ADD CONSTRAINT wanted_position_user_user_about_me
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: wanted_techtools_user_user_about_me (table: wanted_techtools_user)
ALTER TABLE wanted_techtools_user ADD CONSTRAINT wanted_techtools_user_user_about_me
    FOREIGN KEY (user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.
