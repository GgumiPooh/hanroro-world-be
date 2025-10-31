package com.ggumipooh.hanroroworld.be.controller;


import com.ggumipooh.hanroroworld.be.model.Album;
import com.ggumipooh.hanroroworld.be.model.Goods;
import com.ggumipooh.hanroroworld.be.model.Song;
import com.ggumipooh.hanroroworld.be.model.activity.Activity;
import com.ggumipooh.hanroroworld.be.service.ActivityService;
import com.ggumipooh.hanroroworld.be.service.AlbumService;
import com.ggumipooh.hanroroworld.be.service.GoodsService;
import com.ggumipooh.hanroroworld.be.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PublicController {
    private final ActivityService activityService;
    private final AlbumService albumService;
    private final SongService songService;
    private final GoodsService goodsService;

    @GetMapping("/activity")
    public List<Activity> getActivities() {
        return  activityService.getAllActivities();
    }

    @GetMapping("/album")
    public List<Album> getAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/song")
    public List<Song> getSongs() {
        return songService.getAll();
    }

    @GetMapping("/song/{songId}")
    public Song getSong(@PathVariable Long songId) {
        return songService.getById(songId);
    }

    @GetMapping("/goods")
    public List<Goods> getGoods() {
        return goodsService.getAll();
    }

    @GetMapping("/goods/{goodsId}")
    public Goods getGoods(@PathVariable Long goodsId) {
        return goodsService.getById(goodsId);
    }
}
