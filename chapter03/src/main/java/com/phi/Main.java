package com.phi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Chapter03 c3 = new Chapter03();
        c3.Third01();
        c3.Third02();
        c3.Third03();
        c3.Third04();

        System.out.println("\nequationFirst");
        EquationFirst ef = new EquationFirst();
        System.out.printf("2x + 8 = 0에 의해, x는 %d \n", ef.equationFirst(2, 8));
        System.out.printf("5x - 30 = 0에 의해, x는 %d \n", ef.equationFirst(5, -30));
        System.out.printf("7x + 49 = 0에 의해, x는 %d \n", ef.equationFirst(7, 49));

        Example example = new Example();
        example.compareOperatorExample();
        example.logicalOperatorExample();
        example.bitLogicExample();
        example.bitShiftExample1();
        example.bitShiftExample2();
        example.assignmentOperatorExample();
        example.conditionalOperationExample();

        Exercise exercise = new Exercise();
        exercise.exercise01();
        exercise.exercise02();
        exercise.exercise03();
        exercise.exercise04();
        exercise.exercise05();
        exercise.exercise06();
        exercise.exercise07();
    }
}
