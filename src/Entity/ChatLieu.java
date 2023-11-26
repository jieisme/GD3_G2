/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author zudd4
 */
public class ChatLieu {

    private int id;
    private String tenChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(int id, String tenChatLieu) {
        this.id = id;
        this.tenChatLieu = tenChatLieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoai() {
        return tenChatLieu;
    }

    public void setLoai(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }
}
