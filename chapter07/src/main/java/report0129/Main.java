package report0129;

public class Main {
	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Tiger t = new Tiger();
		Swam s = new Swam();
		Fox f = new Fox();

		r.jumping();
		t.sound();
		f.sound();

		Animal[] animals = new Animal[4];
		animals[0] = r;
		animals[1] = t;
		animals[2] = s;
		animals[3] = f;
		for(Animal animal : animals) {
			System.out.println();
			animal.poo(animal.eat(r));
			animal.poo(animal.eat(t));
			animal.poo(animal.eat(s));
			animal.poo(animal.eat(f));
			animal.sleep();
			animal.breathe();
		}
	}
}
