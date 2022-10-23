package com.mohkhz.tanetwork.Model.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Mohammad mehdi khajhezadeh
 * @project TA-network
 * @email_support eng.khajhezadeh@gmail.com
 * @create 21 October 2022 at 12:56 AM
 */
@Entity(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    @NotNull
    @NotBlank
    private String fileName;

    @Column(name = "local_address")
    @NotNull
    @NotBlank
    private String localAddress;

    @Column(name = "online_address")
    @NotNull
    @NotBlank
    private String onlineAddress;

    public File() {
    }

    public File(Long id, String fileName, String localAddress, String onlineAddress) {
        this.id = id;
        this.fileName = fileName;
        this.localAddress = localAddress;
        this.onlineAddress = onlineAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getOnlineAddress() {
        return onlineAddress;
    }

    public void setOnlineAddress(String onlineAddress) {
        this.onlineAddress = onlineAddress;
    }
}
