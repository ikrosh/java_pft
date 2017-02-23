package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String header;
  private final String name;
  private final String footer;

  public GroupData(String header, String name, String footer) {
    this.header = header;
    this.name = name;
    this.footer = footer;
  }

  public String getHeader() {
    return header;
  }

  public String getName() {
    return name;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }
}
