--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: image_file; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image_file (
    id bigint NOT NULL,
    active boolean NOT NULL,
    creation_date timestamp(6) without time zone NOT NULL,
    exclusion_date timestamp(6) without time zone,
    modification_date timestamp(6) without time zone,
    name character varying(255),
    path character varying(255)
);


ALTER TABLE public.image_file OWNER TO postgres;

--
-- Name: image_file_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.image_file_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.image_file_sequence OWNER TO postgres;

--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    active boolean NOT NULL,
    creation_date timestamp(6) without time zone NOT NULL,
    exclusion_date timestamp(6) without time zone,
    modification_date timestamp(6) without time zone,
    description character varying(255),
    image_file_name character varying(255),
    name character varying(255),
    price_in_cents integer,
    CONSTRAINT product_price_in_cents_check CHECK (((price_in_cents >= 0) AND (price_in_cents <= 10000000)))
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_sequence OWNER TO postgres;

--
-- Data for Name: image_file; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.image_file (id, active, creation_date, exclusion_date, modification_date, name, path) FROM stdin;
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (id, active, creation_date, exclusion_date, modification_date, description, image_file_name, name, price_in_cents) FROM stdin;
1	t	2023-09-03 23:42:50.919508	\N	\N	Black cellphone of unknown brand. It is portable and powerful. 	shiwa-id-Bajw65b3mXo-unsplash.jpg	Smartphone	52050
2	t	2023-09-03 23:43:43.617557	\N	\N	Blue microprocessor of unknown brand. It is portable and powerful. 	harrison-broadbent-f2S93diaVn0-unsplash.jpg	Microprocessor	899
3	t	2023-09-03 23:44:34.868687	\N	\N	White monitor of unknown brand. It is wide and colorful. 	amy-hirschi-9EFF087BPXk-unsplash.jpg	Monitor	88999
4	t	2023-09-03 23:45:29.336302	\N	\N	Black analog camera of unknown brand. It is portable and powerful.	olena-sergienko-9-uSCnBaVGU-unsplash.jpg	Camera	10000
5	t	2023-09-03 23:46:08.766943	\N	\N	Black MIDI cable of unknown brand. It is portable and powerful.	vishnu-mohanan-oXOZAx_MJM4-unsplash.jpg	MIDI cable	1320
6	t	2023-09-03 23:46:48.194579	\N	\N	Black keyboard of unknown brand. It is portable and powerful.	sebastian-banasiewcz-CMs6ZGOdyho-unsplash.jpg	Keyboard	17099
7	t	2023-09-03 23:47:26.753861	\N	\N	Black mouse of unknown brand. It is portable and powerful.	pascal-m-4PchFKrUw84-unsplash.jpg	Mouse	2099
8	t	2023-09-03 23:47:57.461376	\N	\N	Black microphone of unknown brand. It is portable and powerful.	rick-muigo-CyRVio3RgNo-unsplash.jpg	Microphone	38899
9	t	2023-09-03 23:48:25.907122	\N	\N	Black GPU of unknown brand. It is portable and powerful.	nana-dua-1-Sfd9QSPi4-unsplash.jpg	GPU	50099
10	t	2023-09-03 23:48:50.546635	\N	\N	Black headphone of unknown brand. It is portable and powerful.	c-d-x-dBwadhWa-lI-unsplash.jpg	Headphone	5099
\.


--
-- Name: image_file_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.image_file_sequence', 1, false);


--
-- Name: product_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_sequence', 10, true);


--
-- Name: image_file image_file_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image_file
    ADD CONSTRAINT image_file_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

