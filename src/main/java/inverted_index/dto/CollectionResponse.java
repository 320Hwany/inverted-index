package inverted_index.dto;

public record CollectionResponse<T>(
        T data
) {

    public static <T> CollectionResponse<T> of(final T data) {
        return new CollectionResponse<>(data);
    }
}
