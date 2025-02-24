package com.jun.section02.list.comparator;

import com.jun.section02.list.dto.Music;

import java.util.Comparator;

public class DescendingTitle implements Comparator<Music> {
    @Override
    public int compare(Music o1, Music o2) {
        return o2.getTitle().compareTo(o1.getTitle());
    }
}
