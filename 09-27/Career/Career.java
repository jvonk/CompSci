public class Career {
    private String name;
    private int age;
    private String subject;
    private String hobby;
    private String food;

    public Career(String name, int age, String subject, String hobby, String food) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }

    public void printInfo() {
        System.out.println(
                "name: " + name + "\nage: " + age + "\nsubject: " + subject + "\nhobby: " + hobby + "\nfood: " + food);
        printCareer();
    }

    private void printCareer() {
        String career = "";
        if (subject.equals("math")) {
            if (hobby.equals("movies")) {
                if (food.equals("pizza")) {
                    career = "programmer";
                } else if (food.equals("popcorn")) {
                    career = "science fiction writer";
                } 
            } else if (hobby.equals("video games")) {
                if (food.equals("pizza")) {
                    career = "video game programmer";
                } else if (food.equals("popcorn")) {
                    career = "video game designer";
                } 
            } 
        } else if (subject.equals("english")) {
            if (hobby.equals("movies")) {
                if (food.equals("pizza")) {
                    career = "movie designer";
                } else if (food.equals("popcorn")) {
                    career = "director";
                } 
            } else if (hobby.equals("video games")) {
                if (food.equals("pizza")) {
                    career = "video game animator";
                } else if (food.equals("popcorn")) {
                    career = "video game director";
                } 
            } 
        } else if (subject.equals("french")) {
            if (hobby.equals("movies")) {
                if (food.equals("pizza")) {
                    career = "french opera singer";
                } else if (food.equals("popcorn")) {
                    career = "french movie director";
                } 
            } else if (hobby.equals("video games")) {
                if (food.equals("pizza")) {
                    career = "french video game animator";
                } else if (food.equals("popcorn")) {
                    career = "french video game critic";
                } 
            }
        }
        System.out.println("Your future career is a "+career);
    }

    public void updateProfile(String name, int age, String subject, String hobby, String food) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }
}