package validations.structure;

public class AndSpecification<T> extends CompositeSpecification<T> {
    private ReturnSpecification statusSpecification = new ReturnSpecification();
    private Specification<T> leftRule;
    private Specification<T> rightRule;

    public AndSpecification(Specification<T> leftRule, Specification<T> rightRule) {
        this.leftRule = leftRule;
        this.rightRule = rightRule;
    }

    @Override
    public ReturnSpecification isSatisfiedBy(T t) {
        ReturnSpecification firstSpecification = this.leftRule.isSatisfiedBy(t);
        this.statusSpecification.setMessage(firstSpecification.getMessage());
        if (this.statusSpecification.getIsValid()) {
            ReturnSpecification secondSpecification = this.rightRule.isSatisfiedBy(t);
            this.statusSpecification.setMessage(secondSpecification.getMessage());
        }

        return this.statusSpecification;
    }
}
