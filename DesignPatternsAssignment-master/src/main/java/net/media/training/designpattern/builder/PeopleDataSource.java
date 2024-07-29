package net.media.training.designpattern.builder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 10:04:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleDataSource {
    public static String getPeopleXml(List<Person> persons) {
        String finalXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        XmlTagBuilder peopleTag = new XmlTagBuilder().setName("People").addAttribute("number",String.valueOf(persons.size()));
        for (Person person : persons) {

            XmlTagBuilder personTag = new XmlTagBuilder().setName("Person").addAttribute("id", String.valueOf(person.getId())).addAttribute("name", String.valueOf(person.getName()));
            XmlTagBuilder addressTag = new XmlTagBuilder().setName("Address");
            XmlTagBuilder cityTag = new XmlTagBuilder().setName("City").setValue(person.getCity());
            XmlTagBuilder countryTag = new XmlTagBuilder().setName("Country").setValue(person.getCountry());
            addressTag.addChildTags(cityTag).addChildTags(countryTag);
            personTag.addChildTags(addressTag);
            peopleTag.addChildTags(personTag);

//            peopleTag.addChildTags(personTag.addChildTags(addressTag.addChildTags(cityTag).addChildTags(countryTag)));
        }
        finalXML += peopleTag.build();
        return finalXML;
    }
}