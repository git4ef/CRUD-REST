package ef.model;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {
    @Id
    @Column(name = "id_file")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "file_name")
    private String name;
    @Column(name = "file_path")
    private String filePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public File() {
    }

    public File(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public File(Integer id, String name, String filePath) {
        this.id = id;
        this.name = name;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
