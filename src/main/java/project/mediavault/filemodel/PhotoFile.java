package project.mediavault.filemodel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import project.mediavault.model.Photo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class PhotoFile {

    private Photo photo;
    private Document document;

    public PhotoFile(Photo photo) {
        this.photo = photo;
        updateDocumentFromPhoto();
    }

    public PhotoFile(Document document) {
        this.document = document;
        updatePhotoFromDocument();
    }

    // TODO Media File
    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        updateDocumentFromPhoto();
    }

    // TODO Document
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updatePhotoFromDocument();
    }

    // TODO Basic Fields
    public int getId() {
        return photo.getId();
    }

    public void setId(int id) {
        photo.setId(id);
        updateDocumentFromPhoto();
    }

    public String getTitle() {
        return photo.getTitle();
    }

    public void setTitle(String title) {
        photo.setTitle(title);
        updateDocumentFromPhoto();
    }

    public String getFileURL() {
        return photo.getFileURL();
    }

    public void setFileURL(String fileURL) {
        photo.setFileURL(fileURL);
        updateDocumentFromPhoto();
    }

    public Long getSize() {
        return photo.getSize();
    }

    public void setSize(Long size) {
        photo.setSize(size);
        updateDocumentFromPhoto();
    }

    // TODO Extra Fields


    // TODO Update Document
    private void updateDocumentFromPhoto() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document d = document;
        Node rootElement = d.createElement("photo");

        Node idElement = d.createElement("id");
        idElement.appendChild(d.createTextNode("" + getId()));
        Node titleElement = d.createElement("title");
        titleElement.appendChild(d.createTextNode(getTitle()));
        Node fileURLElement = d.createElement("fileURL");
        fileURLElement.appendChild(d.createTextNode(getFileURL()));
        Node sizeElement = d.createElement("size");
        sizeElement.appendChild(d.createTextNode("" + getSize()));

        rootElement.appendChild(idElement);
        rootElement.appendChild(titleElement);
        rootElement.appendChild(fileURLElement);
        rootElement.appendChild(sizeElement);

        document.appendChild(rootElement);
    }

    private void updatePhotoFromDocument() {
        Document d = document;
        photo = new Photo();
        photo.setId(Integer.parseInt(d.getElementsByTagName("id").item(0).getTextContent()));
        photo.setTitle(d.getElementsByTagName("title").item(0).getTextContent());
        photo.setSize(Long.parseLong(d.getElementsByTagName("size").item(0).getTextContent()));
        photo.setFileURL(d.getElementsByTagName("fileURL").item(0).getTextContent());
    }

}
