package validations.structure;

public interface Specification<T> {
    ReturnSpecification isSatisfiedBy(T t);
    Specification<T> and(Specification<T> other);
}
