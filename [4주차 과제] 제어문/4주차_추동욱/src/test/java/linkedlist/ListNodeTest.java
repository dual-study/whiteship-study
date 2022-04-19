package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("연결 리스트")
class ListNodeTest {
    @Nested
    @DisplayName("Node 추가는")
    class Descrive_add{
        @Nested
        @DisplayName("head와 추가할 노드가 주어지면")
        class Context_with_headNode_and_nodeToAdd{
            ListNode head;
            ListNode nodeToAdd;
            int position;

            @BeforeEach
            void setUp(){
                position = 1;
                head = new ListNode(1);
                nodeToAdd = new ListNode(2);
            }

            @Test
            @DisplayName("postion index에 head에 노드를 추가하고 head를 반환한다.")
            void it_add_to_head_and_return_head(){
                ListNode.add(head, nodeToAdd, position);
                assertTrue(ListNode.contains(head, nodeToAdd));
            }
        }
    }

    @Nested
    @DisplayName("Node 제거는")
    class Descrive_remove{
        int size = 30;
        ListNode head;

        @BeforeEach
        void setUp(){
            head = new ListNode(0);

            IntStream.range(1, size).forEach(i -> {
                ListNode node = new ListNode(i);
                ListNode.add(head, node, i);
            });
        }

        @Nested
        @DisplayName("head와 삭제할 index가 주어지면")
        class Context_with_headNode_and_exist_node{
            int positionToDelete;

            @BeforeEach
            void setUp(){
                positionToDelete = getValidPosition(size);
            }

            @Test
            @DisplayName("head에서 node를 제거하고 head를 리턴한다")
            void it_remove_node_and_return_haad(){
                ListNode nodeToDelete = ListNode.find(head, positionToDelete);

                ListNode.remove(head, positionToDelete);
                assertEquals(size - 1, ListNode.size(head));
                assertFalse(ListNode.contains(head, nodeToDelete));
            }
        }

        @Nested
        @DisplayName("postion이 list szie보다 크다면")
        class Context_with_headNode_and_postion_bigger_size{
            int positionToDelete;

            @BeforeEach
            void setUp(){
                positionToDelete = size + size;
            }

            @Test
            @DisplayName("head만 리턴한다")
            void it_return_head(){
                ListNode.remove(head, positionToDelete);

                assertEquals(size, ListNode.size(head));
            }
        }
    }

    @Nested
    @DisplayName("Node 포함 여부는")
    class Descrive_contains{
        ListNode head;
        ListNode nodeToCheck;
        int size = 30;

        @BeforeEach
        void setUp(){
            head = prepareHead(size);
        }

        @Nested
        @DisplayName("head에 존재하는 node가 주어지면")
        class Context_with_exist_node{

            @BeforeEach
            void setUp(){
                int position = getValidPosition(size);
                nodeToCheck = ListNode.find(head, position);
            }

            @Test
            @DisplayName("true를 리턴한다.")
            void it_return_true(){
                boolean result = ListNode.contains(head, nodeToCheck);
                assertTrue(result);
            }
        }

        @Nested
        @DisplayName("head 에 존재하지 않는 node가 주어지면")
        class Context_with_non_exist_node{

            @BeforeEach
            void setUp(){
                nodeToCheck = new ListNode(300);
            }

            @Test
            @DisplayName("false를 리턴한다.")
            void it_return_false(){
                boolean result = ListNode.contains(head, nodeToCheck);
                assertFalse(result);
            }
        }
    }

    @Nested
    @DisplayName("검색은")
    class Descrive_find{
        ListNode head;
        int positionTofind;
        int size = 30;

        @BeforeEach
        void setUp(){
            head = prepareHead(size);
        }

        @Nested
        @DisplayName("head와 position이 주어지면")
        class Context_with_position{
            @BeforeEach
            void setUp(){
                positionTofind = getValidPosition(size);
            }
            @Test
            @DisplayName("postion에 해당하는 node를 반환한다.")
            void it_return_node(){
                ListNode node = ListNode.find(head, positionTofind);
                assertNotNull(node);
                assertEquals(positionTofind, node.getValue());
            }
        }
        @Nested
        @DisplayName("size보다 큰 position이 주어지면")
        class Context_with_bigger_size{
            @BeforeEach
            void setUp(){
                positionTofind = size + size;
            }

            @Test
            @DisplayName("범위를 벗어났다는 예외를 던진다.")
            void it_throw_indexOutOfBoundsExdception(){
                assertThrows(IndexOutOfBoundsException.class,
                        () -> ListNode.find(head, positionTofind));
            }
        }
    }

    private ListNode prepareHead(int size){
        ListNode head = new ListNode(0);

        IntStream.range(1, size).forEach(i -> {
            ListNode node = new ListNode(i);
            ListNode.add(head, node, i);
        });
        return head;
    }

    private int getValidPosition(int size){
        Random random = new Random();
        return random.nextInt(size);
    }
}