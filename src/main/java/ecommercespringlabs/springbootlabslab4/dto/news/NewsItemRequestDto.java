package ecommercespringlabs.springbootlabslab4.dto.news;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
public class NewsItemRequestDto {
    @NotBlank(message = "Title is required.")
    @Size(max = 50, message = "Title must not exceed 50 characters.")
    String title;

    @NotBlank(message = "Description is required.")
    @Size(max = 255, message = "Description must not exceed 255 characters.")
    String description;

    @NotNull(message = "Category is required.")
    @Size(max = 50, message = "Category must not exceed 50 characters.")
    String category;

}
