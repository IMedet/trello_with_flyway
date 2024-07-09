package kz.medet.trello;

import kz.medet.trello.dtos.TaskCategoriesDto;
import kz.medet.trello.mapper.TaskCategoriesMapper;
import kz.medet.trello.model.TaskCategories;
import kz.medet.trello.model.User;
import kz.medet.trello.repository.TaskCategoriesRepository;
import kz.medet.trello.repository.TasksRepository;
import kz.medet.trello.service.TaskCategoriesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TrelloApplicationTests {

	@Autowired
	private TaskCategoriesMapper taskCategoriesMapper;

	@Autowired
	private TaskCategoriesRepository taskCategoriesRepository;

	@Autowired
	private TaskCategoriesService taskCategoriesService;


	@Test
	void checkTaskCategoryToDto(){
		TaskCategories taskCategories = new TaskCategories();
		taskCategories.setName("Task3");

		TaskCategoriesDto taskCategoriesDto = taskCategoriesMapper.toTaskCategoriesDto(taskCategories);
		Assertions.assertNotNull(taskCategories);
		Assertions.assertEquals(taskCategories.getId(), taskCategoriesDto.getId());
		Assertions.assertEquals(taskCategories.getName(),taskCategoriesDto.getName());
		Assertions.assertNotNull(taskCategoriesDto);

	}

	@Test
	void checkGetAllTasks(){
		TaskCategories taskCategories = new TaskCategories();
		taskCategories.setName("Task 1");

		taskCategoriesRepository.deleteAll();
		taskCategoriesRepository.save(taskCategories);

		List<TaskCategoriesDto> taskCategoriesList = taskCategoriesService.getAllTaskCategories();

		Assertions.assertTrue(taskCategoriesList.size()>0);
		Assertions.assertNotNull(taskCategoriesList.get(0));
		Assertions.assertEquals(taskCategoriesList.get(0).getId(), taskCategories.getId());
		Assertions.assertEquals(taskCategoriesList.get(0).getName(), taskCategories.getName());

		taskCategoriesRepository.deleteAll();
	}

}
