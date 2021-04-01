package lab2.api;

import lab2.models.NewEntity;
import lab2.models.TestEntity;
import models.enums.ResultType;

import java.util.Optional;

public interface IEntityDataProvider {
    public Long createEntity(String name, String description, Boolean check, NewEntity newEntity);
    public ResultType updateEntity(Long id, String name, String description, Boolean check, NewEntity newEntity);
    public void update(TestEntity entity);
    public ResultType delete(Long Id);
    public Optional<TestEntity> getById(Class<TestEntity> entity, Long id);
    public Long save(TestEntity entity);
}
