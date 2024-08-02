--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-08-02 09:47:58

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
-- TOC entry 217 (class 1259 OID 25608)
-- Name: inventory; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventory (
    amount bigint,
    item_id bigint NOT NULL,
    warehouse_id bigint NOT NULL
);


ALTER TABLE public.inventory OWNER TO postgres;

--
-- TOC entry 4791 (class 0 OID 25608)
-- Dependencies: 217
-- Data for Name: inventory; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.inventory (amount, item_id, warehouse_id) VALUES (100, 1, 1);
INSERT INTO public.inventory (amount, item_id, warehouse_id) VALUES (100, 1, 14);


--
-- TOC entry 4645 (class 2606 OID 25612)
-- Name: inventory inventory_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT inventory_pkey PRIMARY KEY (item_id, warehouse_id);


--
-- TOC entry 4646 (class 2606 OID 25635)
-- Name: inventory fkix9yxgetau1y25hhnv42gsiok; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT fkix9yxgetau1y25hhnv42gsiok FOREIGN KEY (warehouse_id) REFERENCES public.warehouse(id);


--
-- TOC entry 4647 (class 2606 OID 25630)
-- Name: inventory fkrflym5lxj6xhmu4ok3ohmun5a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory
    ADD CONSTRAINT fkrflym5lxj6xhmu4ok3ohmun5a FOREIGN KEY (item_id) REFERENCES public.item(id);


-- Completed on 2024-08-02 09:47:58

--
-- PostgreSQL database dump complete
--

