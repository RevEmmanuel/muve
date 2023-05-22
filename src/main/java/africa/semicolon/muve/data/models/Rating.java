package africa.semicolon.muve.data.models;

public enum Rating {

    FAILURE(1),
    BAD(2),
    GOOD(3),
    SATISFACTORY(4),
    EXCELLENT(5);

    private int rating;

    Rating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
