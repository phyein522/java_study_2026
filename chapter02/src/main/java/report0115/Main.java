package report0115;

public class Main {
    public void main(String[] args) {
        IntegerType i = new IntegerType();
        i.useInteger();

        CharType c = new CharType();
        c.useChar();

        FDType fd = new FDType();
        fd.useFloatDouble();

        BooleanType b = new BooleanType();
        b.useBoolean();

        StringType s = new StringType();
        s.useString();
    }
}
