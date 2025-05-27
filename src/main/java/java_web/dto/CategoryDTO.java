package java_web.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;


@Component
public class CategoryDTO {
    private int id;

    @NotBlank(message = "Tên phòng ban không được để trống!")
    private String name;
    private String description;
    private byte status;

    public CategoryDTO() {
    }

    public CategoryDTO(int id, String name, String description, byte status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
