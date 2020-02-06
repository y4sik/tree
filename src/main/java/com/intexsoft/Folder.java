package com.intexsoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Folder {
    private Long id;
    private Long parentId;
    private String name;
    private Collection<Folder> childFolders = new ArrayList<>();

    public Folder(Long id, Long parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getParentId() {
        return parentId;
    }

    public Collection<Folder> getChildFolders() {
        return childFolders;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", childFolders=" + childFolders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return id.equals(folder.id) &&
                Objects.equals(parentId, folder.parentId) &&
                name.equals(folder.name) &&
                childFolders.equals(folder.childFolders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, name, childFolders);
    }
}
