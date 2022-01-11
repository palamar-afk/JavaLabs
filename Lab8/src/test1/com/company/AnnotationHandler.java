package test1.com.company;

public class AnnotationHandler {
    @Annotation(fieldA = 57, fieldB = 43)
    public int CalculateSum(int fieldA, int fieldB){
        return fieldA + fieldB;
    }
}