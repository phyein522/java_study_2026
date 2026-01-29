package report0129;

public class Main {
	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Tiger t = new Tiger();
		Swam s = new Swam();
		Fox f = new Fox();

		r.eat(t);
		r.eat(s);
		r.eat(f);
		r.poo(r.eat(s));
		r.poo(r.eat(t));

		t.poo(t.eat(r));
		t.poo(t.eat(f));

		f.breathe();
		r.jumping();
		t.sound();
		f.sound();
	}
}
