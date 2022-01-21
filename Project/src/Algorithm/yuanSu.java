package Algorithm;

import java.util.ArrayList;

public class yuanSu {
    private String author;
    private ArrayList<String> paragraphs;
    private String id;
    private String title;
    private yuanSu pre;
    private yuanSu next = null;
    private String paragraph;
    private ArrayList<String> tags;
    private String tag = null;
    private String dynasty;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    private String degree;
    public ArrayList<String> getTags() {
        return tags;
    }

    public String getTag() {

        if (tags != null) {
            int i = 0;
            tag = tags.get(i);
            i++;
            while (i < tags.size()) {
                tag += tags.get(i);
                i++;
            }
        }
        return tag;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author.replaceAll(" ", "");
    }

    public ArrayList<String> getParagraphs() {
        return paragraphs;
    }

    public String getId() {
        return id;
    }

    public String getDynasty() {
        return dynasty;
    }

    public String getParagraph() {
        if (paragraphs.size() == 0) {
            return paragraph = null;
        } else {
            return paragraph = paragraphs.get(0);
        }

    }

    public String getTitle() {
        return title.replaceAll(",", "");
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public void setParagraphs(ArrayList<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*public yuanSu(String author,ArrayList<String> paragraphs,String id,String title) {
        this.author = author;
        this.id =id;
        this.title = title;
        this.paragraphs = paragraphs;
    }*/
    @Override
    public String toString() {
        return "yuanSu{" + "id=" + id + ", paragraphs =" + paragraphs + ", id = " + id + ", title=" + title;
    }

}
