package com.intexsoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    /**
     *        2                  1
     *      /  \               /  \
     *    17   11             3    5
     *        /  \          /  \
     *       4    6        7    9
     *                   /  \
     *                 10   15
     */
    public static void main(String[] args) {

        Collection<Folder> folders = new ArrayList<>();

        folders.add(new Folder(3L, 1L, "folder3"));
        folders.add(new Folder(7L, 3L, "folder7"));
        folders.add(new Folder(9L, 3L, "folder9"));
        folders.add(new Folder(1L, null, "folder1"));
        folders.add(new Folder(5L, 1L, "folder5"));
        folders.add(new Folder(10L, 7L, "folder10"));
        folders.add(new Folder(15L, 7L, "folder15"));

        folders.add(new Folder(4L, 11L, "folder3"));
        folders.add(new Folder(17L, 2L, "folder17"));
        folders.add(new Folder(11L, 2L, "folder11"));
        folders.add(new Folder(2L, null, "folder2"));
        folders.add(new Folder(6L, 11L, "folder6"));

        Map<Long, Folder> foldersMap = new HashMap<>();

        for (Folder folder : folders) {
            Long parentId = folder.getParentId();
            if (foldersMap.containsKey(parentId)) {
                foldersMap.get(parentId).getChildFolders().add(folder);
            }
            foldersMap.put(folder.getId(), folder);

            for (Folder folderFromMap : foldersMap.values()) {
                if (folder.getId().equals(folderFromMap.getParentId())) {
                    folder.getChildFolders().add(folderFromMap);
                }
            }
        }

        Collection<Folder> rootFolders =
                folders.stream().filter(folder -> folder.getParentId() == null).collect(Collectors.toList());

        System.out.println(rootFolders);
    }
}