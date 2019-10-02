package com.findmyfriends.alpha.repository.impl;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.repository.EventHardwareRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository("EventHardwareInMemory")
public class EventHardwareRepositoryImpl implements EventHardwareRepository {

    private static  EventHardwareRepositoryImpl repository = null;
    private Set<EventHardware> eventHardwares;

    public EventHardwareRepositoryImpl(){
        eventHardwares = new HashSet<>();
    }


    public static EventHardwareRepositoryImpl getRepository() {

        if(repository == null){
            return new EventHardwareRepositoryImpl();
        }
        return repository;
    }

    public EventHardware create(EventHardware eventHardwareInst) {

        eventHardwares.add(eventHardwareInst);
        return eventHardwareInst;
    }

    public EventHardware read(String id) {

        return eventHardwares.stream().filter(eventHardwareInst -> eventHardwareInst.getEvent().equals(id)).findAny().orElse(null);
    }

    public EventHardware update(EventHardware eventHardwareInst) {

        EventHardware inDB = read(eventHardwareInst.getEvent());

        if(inDB != null){
            eventHardwares.remove(inDB);
            eventHardwares.add(eventHardwareInst);
            return eventHardwareInst;
        }

        return null;
    }

    public void delete(String id) {

        EventHardware inDB = read(id);
        eventHardwares.remove(inDB);

    }

    @Override
    public Set<EventHardware> getAll() {
        return eventHardwares;
    }

    @Override
    public List<EventHardware> findAll() {
        return null;
    }

    @Override
    public List<EventHardware> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<EventHardware> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<EventHardware> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(EventHardware eventHardware) {

    }

    @Override
    public void deleteAll(Iterable<? extends EventHardware> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends EventHardware> S save(S s) {
        return null;
    }

    @Override
    public <S extends EventHardware> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<EventHardware> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends EventHardware> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<EventHardware> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public EventHardware getOne(String s) {
        return null;
    }

    @Override
    public <S extends EventHardware> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends EventHardware> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends EventHardware> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends EventHardware> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EventHardware> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends EventHardware> boolean exists(Example<S> example) {
        return false;
    }
}

