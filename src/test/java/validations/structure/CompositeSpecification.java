package validations.structure;

public abstract class CompositeSpecification<T> implements Specification<T> {
    protected ReturnSpecification returnSpecification = new ReturnSpecification();
    @Override
    public Specification<T> and(Specification<T> other) {
        return new AndSpecification<>(this, other);
    }

}
