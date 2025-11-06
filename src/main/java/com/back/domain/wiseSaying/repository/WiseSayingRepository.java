package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
* 역할 : 데이터의 조회/수정/삭제/생성을 담당

스캐너 사용금지, 출력 금지*/
public class WiseSayingRepository {
    String dbPath = "db/wiseSaying/";
    //file 여닫는거 통일 시키거나 따로 빼기

    public void create(WiseSaying w) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbPath + w.getId() + ".json"))){
            String formattedString = String.format(
                    "{\n" +
                            "\"id\" : %s,\n" +
                            "\"content\" : \"%s\",\n" +
                            "\"author\" : \"%s\"\n"  +
                    "}"
                    ,w.getId(),w.getContent(),w.getAuthor());
            bw.write(formattedString);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void update(WiseSaying w) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbPath + w.getId() + ".json"))){
            String formattedString = String.format(
                    """
                            {
                            "id" : %d,
                            "content" : "%s",
                            "author" : "%s"
                            }
                    """
                    ,w.getId(),w.getContent(),w.getAuthor());
            bw.write(formattedString);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void delete(int wiseId) {
        File file = new File(dbPath + wiseId + ".json");
        if (file.exists()){
            file.delete();
        }
    }
    public ArrayList<WiseSaying> findAll() {
        File[] files = new File(dbPath).listFiles();
        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

        if (files == null){
            return wiseSayings;
        }
        for(File file : files){
            if(file.getName().endsWith(".json")){
                WiseSaying w = JsonToWiseSaying(file);
                wiseSayings.add(w);
            }
        }
        wiseSayings.sort((a,b) -> b.getId() - a.getId());
        return wiseSayings;
    }
    public WiseSaying findById(int wiseId) {
        File[] files = new File(dbPath).listFiles();
        if (files == null){
            return null;
        }
        for(File file : files){
            if(file.getName().equals(wiseId + ".json")){
                return JsonToWiseSaying(file);
            }
        }
        return null;
    }
    public void setLastId(int lastId) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbPath + "lastId.txt"))){
            bw.write(String.valueOf(lastId));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public int getLastId() {
        File file = new File(dbPath + "lastId.txt");
        if (file.exists()){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                return Integer.parseInt(br.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }

    private WiseSaying JsonToWiseSaying(File file){
        //jsonString -> WiseSaying 객체 반환
        String fileString;
        try(BufferedReader bf = new BufferedReader(new FileReader( file))){
            fileString = bf.lines().collect(Collectors.joining("\n"));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        String regexString =
                "\"id\"\\s:\\s(\\d+),\\s*" +
            "\"content\"\\s:\\s\"([^\"]*)\",\\s*" +
                "\"author\"\\s:\\s\"([^\"]*)\"";
        Pattern pattern = Pattern.compile(regexString,Pattern.DOTALL);
        Matcher matcher = pattern.matcher(fileString);

        if (matcher.find()){
            int id = Integer.parseInt(matcher.group(1));
            String content = matcher.group(2);
            String author = matcher.group(3);
            return new WiseSaying(id,content,author);
        }
        return null;
    }

}
