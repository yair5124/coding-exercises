package ineed.to.practice;

import java.util.concurrent.Callable;

interface Bird {
    Egg lay();
}

class Chicken implements Bird {
    public Chicken() {
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
    }

    public Egg lay() {
        Egg egg = new Egg(new Callable<Bird>() {
            public Chicken call() throws Exception {
                return new Chicken();
            }
        });
        egg.hatch();
        return egg;
    }
}

class Egg {

    private boolean hatched = false;
    private Bird parent;

    public Egg(Callable<Bird> createBird) {
        try {
            this.parent = createBird.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bird hatch() {
        if (hatched) {
            throw new IllegalStateException("Birds cannot be hatched twice");
        }
        hatched = true;
        return this.parent;
    }
}