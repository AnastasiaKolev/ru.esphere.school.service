package ru.esphere.school.service;


import ru.esphere.school.data.Member;
import ru.esphere.school.data.MembersGroup;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Рефакторинг с применением Stream API
 * Необходимо произвести рефакторинг кода класса Finder с применением stream api.
 */

public class Finder {
    /**
     * Поиск групп людей старше определенного возраста.
     *
     * @param groups    группы
     * @param targetAge возраст для поиска
     * @return список имен групп из списка групп старше возраста targetAge
     */
    public Set<String> findGroupsWithOldMembers(List<MembersGroup> groups, int targetAge) {

        // Создание метода возвращающего имена групп с участниками страрше targetAge

//        Set<String> groupsNames = new HashSet<>();
//        for (MembersGroup membersGroup : groups) {
//            String name = membersGroup.getGroupName();
//            for (Member member : membersGroup.getMembers()) {
//                if (member.getAge() > targetAge) {
//                    groupsNames.add( name );
//                }
//            }
//        }


        return groups.stream().
                filter( membersGroup -> membersGroup.getMembers().stream()
                        .allMatch( member -> member.getAge() > targetAge ) )
                .map( MembersGroup::getGroupName )
                .collect( Collectors.toSet() );


//        return groups.stream()
//                .filter( membersGroup -> membersGroup.getMembers().stream()
//                        .anyMatch( member -> member.getAge() > targetAge ))
//                .map( MembersGroup::getGroupName )
//                .collect( Collectors.toSet() );
    }

    /**
     * Поиск в группах имен людей старше определенного возраста.
     *
     * @param groups    группы
     * @param targetAge возраст для поиска
     * @return список имен людей из списка групп старше возраста targetAge
     */
    public Set<String> findOldMembers(List<MembersGroup> groups, int targetAge) {

//        Set<String> groupsNames = new HashSet<>();
//        for (MembersGroup membersGroup : groups) {
//            for (Member member : membersGroup.getMembers()) {
//                if (member.getAge() > targetAge) {
//                    String name = member.getName();
//                    groupsNames.add( name );
//                }
//            }
//        }

        // Рефакторинг метода возвращающего имена участников страрше targetAge

        return groups.stream()
                .flatMap( membersGroup -> membersGroup.getMembers().stream() )
                .filter( member -> member.getAge() > targetAge )
                .map( Member::getName )
                .collect( Collectors.toSet() );
    }
}