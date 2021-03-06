--
--  Copyright 2009 Denys Pavlov, Igor Azarnyi
--
--     Licensed under the Apache License, Version 2.0 (the "License");
--     you may not use this file except in compliance with the License.
--     You may obtain a copy of the License at
--
--         http://www.apache.org/licenses/LICENSE-2.0
--
--     Unless required by applicable law or agreed to in writing, software
--     distributed under the License is distributed on an "AS IS" BASIS,
--     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--     See the License for the specific language governing permissions and
--     limitations under the License.
--

--
-- This script is for MySQL only with some Derby hints inline with comments
-- We highly recommend you seek YC's support help when upgrading your system
-- for detailed analysis of your code.
--
-- Upgrades organised in blocks representing JIRA tasks for which they are
-- necessary - potentially you may hand pick the upgrades you required but
-- to keep upgrade process as easy as possible for future we recommend full
-- upgrades
--

--
-- YC-870 Request for price prices
--

alter table TSKUPRICE add column PRICE_UPON_REQUEST bit not null default 0;
-- alter table TSKUPRICE add column PRICE_UPON_REQUEST smallint not null default 0;

--
-- YC-871 Calculated B2B prices
--

alter table TSKUPRICE add column AUTO_GENERATED bit not null default 0;
-- alter table TSKUPRICE add column AUTO_GENERATED smallint not null default 0;



    create table TSKUPRICERULE (
        SKUPRICERULE_ID bigint not null auto_increment,
        VERSION bigint not null default 0,
        CODE varchar(255) not null unique,
        RANK integer default 500,
        SHOP_CODE varchar(255) not null,
        CURRENCY varchar(5) not null,
        RULE_ACTION varchar(1) not null,
        ELIGIBILITY_CONDITION longtext not null,
        MARGIN_PERCENT decimal(9,2),
        MARGIN_AMOUNT decimal(9,2),
        ADD_DEFAULT_TAX bit not null,
        ROUNDING_UNIT decimal(9,2),
        PRICE_TAG varchar(255),
        PRICE_REF varchar(255),
        PRICE_POLICY varchar(255),
        NAME varchar(255) not null,
        DESCRIPTION varchar(1000),
        TAG varchar(255),
        ENABLED bit not null,
        ENABLED_FROM datetime,
        ENABLED_TO datetime,
        CREATED_TIMESTAMP datetime,
        UPDATED_TIMESTAMP datetime,
        CREATED_BY varchar(64),
        UPDATED_BY varchar(64),
        GUID varchar(36) not null unique,
        primary key (SKUPRICERULE_ID)
    );

    create index SKUPRICERULE_SHOP_CODE on TSKUPRICERULE (SHOP_CODE);
    create index SKUPRICERULE_CURRENCY on TSKUPRICERULE (CURRENCY);
    create index SKUPRICERULE_ENABLED on TSKUPRICERULE (ENABLED);

--     create table TSKUPRICERULE (
--         SKUPRICERULE_ID bigint not null GENERATED BY DEFAULT AS IDENTITY,
--         VERSION bigint not null default 0,
--         CODE varchar(255) not null unique,
--         RANK integer default 500,
--         SHOP_CODE varchar(255) not null,
--         CURRENCY varchar(5) not null,
--         RULE_ACTION varchar(1) not null,
--         ELIGIBILITY_CONDITION varchar(4000) not null,
--         MARGIN_PERCENT numeric(9,2),
--         MARGIN_AMOUNT numeric(9,2),
--         ADD_DEFAULT_TAX smallint not null,
--         ROUNDING_UNIT numeric(9,2),
--         PRICE_TAG varchar(255),
--         PRICE_REF varchar(255),
--         PRICE_POLICY varchar(255),
--         NAME varchar(255) not null,
--         DESCRIPTION varchar(1000),
--         TAG varchar(255),
--         ENABLED smallint not null,
--         ENABLED_FROM timestamp,
--         ENABLED_TO timestamp,
--         CREATED_TIMESTAMP timestamp,
--         UPDATED_TIMESTAMP timestamp,
--         CREATED_BY varchar(64),
--         UPDATED_BY varchar(64),
--         GUID varchar(36) not null unique,
--         primary key (SKUPRICERULE_ID)
--     );
--
--     create index SKUPRICERULE_SHOP_CODE on TSKUPRICERULE (SHOP_CODE);
--     create index SKUPRICERULE_CURRENCY on TSKUPRICERULE (CURRENCY);
--     create index SKUPRICERULE_ENABLED on TSKUPRICERULE (ENABLED);

--
-- YC-888 Ensure SYSTEM_PANEL_LABEL is consistent with environment build
--

delete from TSYSTEMATTRVALUE where CODE like 'SYSTEM_PANEL_LABEL';
delete from TATTRIBUTE where CODE like 'SYSTEM_PANEL_LABEL';
