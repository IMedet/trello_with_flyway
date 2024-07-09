package kz.medet.trello.service;

import kz.medet.trello.dtos.TaskCategoriesDto;
import kz.medet.trello.mapper.TaskCategoriesMapper;
import kz.medet.trello.model.TaskCategories;
import kz.medet.trello.model.Tasks;
import kz.medet.trello.repository.TaskCategoriesRepository;
import kz.medet.trello.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoriesService {
    @Autowired
    private TaskCategoriesMapper taskCategoriesMapper;

   @Autowired
   private TaskCategoriesRepository taskCategoriesRepository;

   public List<TaskCategoriesDto> getAllTaskCategories(){
       return taskCategoriesMapper.toTaskCategoriesDtoList(taskCategoriesRepository.findAll());
   }

}
