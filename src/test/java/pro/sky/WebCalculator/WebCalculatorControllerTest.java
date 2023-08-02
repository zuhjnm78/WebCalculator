package pro.sky.WebCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@WebMvcTest(WebCalculatorController.class)
class WebCalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WebCalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        when(calculatorService.welcome()).thenReturn("Добро пожаловать в калькулятор.");
        when(calculatorService.add(5, 3)).thenReturn(8);
        when(calculatorService.subtract(8, 3)).thenReturn(5);
        when(calculatorService.multiply(4, 3)).thenReturn(12);
        when(calculatorService.divide(10, 2)).thenReturn(5);
    }
    @Test
    public void testWelcome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Добро пожаловать в калькулятор."));
    }

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/plus?num1=5&num2=3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5 + 3 = 8"));
    }

    @Test
    public void testSubtract() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/minus?num1=8&num2=3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("8 - 3 = 5"));
    }

    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/multiply?num1=4&num2=3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("4 * 3 = 12"));
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/divide?num1=10&num2=2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("10 / 2 = 5"));
    }

}