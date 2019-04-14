package App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.BlogPost;
import model.BlogPostType;
import model.Tuple;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] arg) {

        Student student1 = new Student("Anthony", 2, "Computer Science");
        Student student2 = new Student("Jennifer", 6, "Art");
        Student student3 = new Student("Peter", 11, "Computer Science");

        List<Student> students = Arrays.asList(student1, student2, student3);

        Collections.shuffle(students);
        //System.out.println(students);

        System.out.println(students.stream().filter(major -> major.getMajor().equals("Computer Science")).count());
        System.out.println(students.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList()));
        System.out.println(students.stream().max(Comparator.comparingInt(Student::getAge)));
//        students.stream().mapToInt(Student::getAge)
//            .forEach(System.out::println);

        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");

        // Using Stream mapToInt(ToIntFunction mapper)
        // and displaying the corresponding IntStream
//        list.stream().mapToInt(num -> Integer.parseInt(num))
//                .filter(num -> num % 3 == 0)
//                .forEach(System.out::println);

        List<Integer> quality = Arrays.asList(3,5,6,7);
        System.out.println(quality.stream().mapToInt(Integer::intValue).sum());
        quality.stream().collect(Collectors.summingInt(Integer::intValue));

        String str = "Hello today is a storm day";
        String[] strArray = str.split(" ");

        List<Associate> associates = students.stream()
                .map(student -> new Associate(student.getName(), student.getAge())
                ).collect(Collectors.toList());

        List<String> names = students.stream()
                .map(student -> student.getName()).collect(Collectors.toList());
        //System.out.println(students.stream().collect(groupingBy(Student::getMajor)));

        //System.out.println(associates);

        BlogPost blogPost1 = new BlogPost("Easter Sunday", "Thien Le", BlogPostType.GUIDE, 1);
        BlogPost blogPost2 = new BlogPost("Lent Sunday", "Anthony", BlogPostType.GUIDE, 5);
        BlogPost blogPost3 = new BlogPost("Norht korea", "Jennifer", BlogPostType.NEWS, 10);

        List<BlogPost> blogPosts = Arrays.asList(blogPost1, blogPost2, blogPost3);

        Map<BlogPostType, List<BlogPost>> postsPerTypeMap = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType));

        System.out.println("For more info visit: https://www.baeldung.com/java-groupingby-collector \n");

        System.out.println("Blog post list by type: " + postsPerTypeMap + "\n");

        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = blogPosts.stream()
                .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

        System.out.println("Group by the blog posts in the list by the type and author combined in a Tuple instance: "
                + postsPerTypeAndAuthor);

        Map<BlogPostType, Set<BlogPost>> postsPerType = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, toSet()));

        System.out.println("Convert to Set: " + postsPerType + "\n");

        Map<String, Map<BlogPostType, List<BlogPost>>> map = blogPosts.stream()
                .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));

        System.out.println("To group the List of BlogPosts find by author and then by type: " + map);

        Map<BlogPostType, Double> averageLikesPerType = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));

        System.out.println("Average number of likes for each blog post type: " + averageLikesPerType + "\n");

        Map<BlogPostType, Integer> likesPerType = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));

        System.out.println("Summing: " + likesPerType + "\n");

        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, maxBy(Comparator.comparingInt(BlogPost::getLikes))));

        System.out.println("Max: " + maxLikesPerPostType + "\n");

        Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, summarizingInt(BlogPost::getLikes)));

        System.out.println("Summary for the likes attribute of the blog posts for each different type: " + likeStatisticsPerType + "\n");

//        Map<BlogPostType, String> postsPerType = blogPosts.stream()
//                .collect(groupingBy(BlogPost::getType),
//                        mapping(BlogPost::getTitle, joining(", ", "Post titles: [", "]")));
//
//
//        EnumMap<BlogPostType, List<BlogPost>> postsPerType = blogPosts.stream()
//                .collect(groupingBy(BlogPost::getType),
//                        () -> new EnumMap<>(BlogPostType.class), toList()));

        ConcurrentMap<BlogPostType, List<BlogPost>> postsPerType2 = blogPosts.parallelStream()
                .collect(groupingByConcurrent(BlogPost::getType));

        System.out.println("Group operation concurrently, stream needs to be parallel: " + postsPerType2 + "\n");

        String str1 = 3 > 2 ? "Yes" : "No";

        System.out.println(str1);

        division(3,2);

        division2("2",-2);

    }

    static double division(int a, int b) {
        if(b<0) {
            throw new IllegalArgumentException("Illegal input");
        }
        return a/b;
    }

    static double division2(String a, int b) {
        double result;
        try{
            Integer c = Integer.parseInt(a);
            return  c/b;
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal exception " + e.getStackTrace());
        }
        return 0;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    String name;
    Integer age;
    String major;
}

@Data
@AllArgsConstructor
class Associate {
    String name;
    Integer age;
}
