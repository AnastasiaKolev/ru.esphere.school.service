import ru.esphere.school.data.Member;
import ru.esphere.school.data.MembersGroup;
import ru.esphere.school.service.Finder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] argv) {
        List<Member> l1 = new ArrayList<>();
        l1.add( new Member( "Alex30", 30 ) );
        l1.add( new Member( "Ann40", 40 ) );
        l1.add( new Member( "Gordon32", 32 ) );

        MembersGroup m1 = new MembersGroup( "group1_min30", l1 );

        List<Member> l2 = new ArrayList<>();
        l2.add( new Member( "Cary18", 18 ) );
        l2.add( new Member( "Katy20", 20 ) );
        l2.add( new Member( "Vivien19", 19 ) );

        MembersGroup m2 = new MembersGroup( "group2_min18", l2 );

        List<Member> l3 = new ArrayList<>();
        l3.add( new Member( "Alex90", 90 ) );
        l3.add( new Member( "Ann70", 70 ) );
        l3.add( new Member( "Gordon59", 59 ) );

        MembersGroup m3 = new MembersGroup( "group3_min59", l3 );

        List<Member> l4 = new ArrayList<>();
        l4.add( new Member( "Rose28", 28 ) );
        l4.add( new Member( "Petr45", 45 ) );
        l4.add( new Member( "Oleg32", 32 ) );

        MembersGroup m4 = new MembersGroup( "group4_min28", l4 );

        List<MembersGroup> membersGroups = new ArrayList( );

        membersGroups.add( m1 );
        membersGroups.add( m2 );
        membersGroups.add( m3 );
        membersGroups.add( m4 );

        Scanner input = new Scanner( System.in );
        System.out.print("Enter the limit for group's age: ");

        int age = input.nextInt();

        Finder result = new Finder();

        System.out.println( "Members list: " +
                result.findOldMembers( membersGroups, age ) );

        System.out.println( "Mature groups list: " +
                result.findGroupsWithOldMembers( membersGroups, age ) );
    }
}
