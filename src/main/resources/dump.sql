-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2019 at 09:22 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11
-- ************************************************************************************************************************************************
-- **** WHEN CREATING THE DATABASE SELECT DATABASE ENCODING: UTF8 AND DATABASE COLLATION UTF8_general_ci to support Romanian special character ****
-- ************************************************************************************************************************************************
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `Carte` (
	`idcarte` bigint(20) NOT NULL AUTO_INCREMENT,
   	`titlu` VARCHAR (100) not null,
    `autori` VARCHAR (100) not null,
    `editura` VARCHAR (100) not null,
    `anCarte` int (11) not null,
    `isbn` varchar(100) not null,
    PRIMARY KEY (`idCarte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `Carte` (`idCarte`, `titlu`, `autori`, `editura`, `anCarte`, `isbn`) VALUES
(33, 'Aplicatie', 'autor1,autor2,autor3' ,'Editura Noastra', 2019, 'asa1');


CREATE TABLE `Produs` (
    `idProdus` bigint(20) NOT NULL AUTO_INCREMENT,
    `nume` VARCHAR (100) not null,
    `producator` VARCHAR (100) not null,
    `pret` int (11) not null,
    `cantitateStoc` int (11),
    `descriere` varchar(100) not null,
    PRIMARY KEY (`idProdus`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4





CREATE TABLE `User` (
    `idUser` bigint(20) NOT NULL AUTO_INCREMENT,
    `nume` VARCHAR (100) not null,
    `prenume` VARCHAR (100) not null,
    `email` varchar(100) not null,
    `parola` varchar(100) not null,
    `adresa` varchar(100) not null,
    PRIMARY KEY (`idUser`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4




CREATE TABLE `Admin` (
    `idUser` bigint(20) NOT NULL AUTO_INCREMENT,
    `nume` VARCHAR (100) not null,
    `prenume` VARCHAR (100) not null,
    `email` varchar(100) not null,
    `parola` varchar(100) not null,
    `telefon` varchar(100) not null,
    `drept` varchar(100) not null,
    PRIMARY KEY (`idUser`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

